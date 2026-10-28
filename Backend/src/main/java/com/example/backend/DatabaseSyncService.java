package com.example.backend.service;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
 
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
 
/**
 * One-way sync: save_db_2 (source) -> save_db_1 (destination, the app's own database).
 *
 * - Reads sync_change_log from save_db_2 (filled by your triggers).
 * - Applies INSERT / UPDATE / DELETE to save_db_1 for any table (no per-table code).
 * - Only updates/deletes rows it copied itself (tracked in sync_source_records),
 *   so rows created directly in save_db_1 are never touched.
 * - Never syncs login_details.
 * - Remembers its position in save_db_1.sync_checkpoint (survives restarts).
 * - Stops at the first error and retries next run, so nothing is skipped silently.
 *
 * Needs record_key in sync_change_log to hold the full row as JSON (row_to_json).
 */
@Service
public class DatabaseSyncService {
 
    private static final Logger log = LoggerFactory.getLogger(DatabaseSyncService.class);
 
    private static final String SOURCE_DB_NAME = "save_db_2";
    private static final String DEST_DB_NAME = "save_db_1";
    private static final String CHECKPOINT_NAME = "save_db_2_to_save_db_1";
    private static final int BATCH_SIZE = 200;
    private static final Pattern SAFE_NAME = Pattern.compile("[A-Za-z0-9_]+");
 
    private final DataSource destDataSource;    // the app's own datasource (save_db_1)
    private final DataSource sourceDataSource;  // save_db_2, built from SOURCE_DB_* variables
    private final Map<String, TableInfo> tableCache = new HashMap<>();
 
    private boolean ready = false;
    private boolean blocked = false;
 
    private record Change(long id, String table, String op, String key) {}
 
    private record TableInfo(List<String> columns, List<String> pkColumns) {}
 
    public DatabaseSyncService(
            DataSource destDataSource,
            @Value("${SOURCE_DB_URL:}") String sourceUrl,
            @Value("${SOURCE_DB_USERNAME:}") String sourceUser,
            @Value("${SOURCE_DB_PASSWORD:}") String sourcePassword) {
        this.destDataSource = destDataSource;
        if (sourceUrl == null || sourceUrl.isBlank()) {
            this.sourceDataSource = null;
        } else {
            DriverManagerDataSource ds = new DriverManagerDataSource();
            ds.setDriverClassName("org.postgresql.Driver");
            ds.setUrl(sourceUrl);
            ds.setUsername(sourceUser);
            ds.setPassword(sourcePassword);
            this.sourceDataSource = ds;
        }
    }
 
    @Scheduled(initialDelay = 30000, fixedDelay = 60000)
    public void syncDatabases() {
        if (blocked) {
            return;
        }
        if (sourceDataSource == null) {
            log.error("Sync DISABLED: SOURCE_DB_URL is not set. Add SOURCE_DB_URL, SOURCE_DB_USERNAME, "
                    + "SOURCE_DB_PASSWORD (save_db_2) in Render environment variables.");
            blocked = true;
            return;
        }
        try {
            if (!ready && !verify()) {
                return;
            }
            runSync();
        } catch (Exception e) {
            log.error("Sync run failed: {}", e.toString(), e);
        }
    }
 
    // ---------------------------------------------------------------- startup checks
 
    private boolean verify() throws SQLException {
        try (Connection src = sourceDataSource.getConnection();
             Connection dst = destDataSource.getConnection()) {
 
            String srcName = currentDatabase(src);
            String dstName = currentDatabase(dst);
            log.info("Sync check: source database = {}, destination database = {}", srcName, dstName);
 
            if (!SOURCE_DB_NAME.equals(srcName) || !DEST_DB_NAME.equals(dstName)) {
                log.error("Sync DISABLED for safety: expected {} -> {} but found {} -> {}.",
                        SOURCE_DB_NAME, DEST_DB_NAME, srcName, dstName);
                blocked = true;
                return false;
            }
 
            try (Statement st = src.createStatement()) {
                st.execute("SELECT id, table_name, operation_type, record_key FROM sync_change_log LIMIT 0");
            }
            try (Statement st = dst.createStatement()) {
                st.execute("SELECT table_name, source_record_id, source_change_id, synced_at "
                        + "FROM sync_source_records LIMIT 0");
                st.execute("CREATE TABLE IF NOT EXISTS sync_checkpoint ("
                        + "name VARCHAR(100) PRIMARY KEY, last_change_id BIGINT NOT NULL)");
            }
        }
        ready = true;
        return true;
    }
 
    private String currentDatabase(Connection c) throws SQLException {
        try (Statement st = c.createStatement();
             ResultSet rs = st.executeQuery("SELECT current_database()")) {
            rs.next();
            return rs.getString(1);
        }
    }
 
    // ---------------------------------------------------------------- main loop
 
    private void runSync() throws SQLException {
        try (Connection src = sourceDataSource.getConnection();
             Connection dst = destDataSource.getConnection()) {
 
            dst.setAutoCommit(false);
            try {
                long last = readCheckpoint(dst);
                dst.commit();
                int applied = 0;
 
                while (true) {
                    List<Change> batch = fetchChanges(src, last);
                    if (batch.isEmpty()) {
                        break;
                    }
                    for (Change c : batch) {
                        try {
                            apply(dst, c);
                            writeCheckpoint(dst, c.id());
                            dst.commit();
                            last = c.id();
                            applied++;
                        } catch (SQLException | RuntimeException e) {
                            dst.rollback();
                            log.error("Sync stopped at change {} ({} on {}): {}. Will retry on the next run.",
                                    c.id(), c.op(), c.table(), e.getMessage());
                            return;
                        }
                    }
                }
                if (applied > 0) {
                    log.info("Sync applied {} change(s); last change id = {}", applied, last);
                }
            } finally {
                try {
                    dst.rollback();
                } catch (SQLException ignored) {
                    // connection is being closed anyway
                }
                try {
                    dst.setAutoCommit(true);
                } catch (SQLException ignored) {
                    // connection is being closed anyway
                }
            }
        }
    }
 
    private List<Change> fetchChanges(Connection src, long afterId) throws SQLException {
        List<Change> list = new ArrayList<>();
        try (PreparedStatement ps = src.prepareStatement(
                "SELECT id, table_name, operation_type, record_key FROM sync_change_log "
                        + "WHERE id > ? ORDER BY id ASC LIMIT ?")) {
            ps.setLong(1, afterId);
            ps.setInt(2, BATCH_SIZE);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(new Change(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4)));
                }
            }
        }
        return list;
    }
 
    private long readCheckpoint(Connection dst) throws SQLException {
        try (PreparedStatement ps = dst.prepareStatement(
                "SELECT last_change_id FROM sync_checkpoint WHERE name = ?")) {
            ps.setString(1, CHECKPOINT_NAME);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? rs.getLong(1) : 0L;
            }
        }
    }
 
    private void writeCheckpoint(Connection dst, long changeId) throws SQLException {
        try (PreparedStatement ps = dst.prepareStatement(
                "INSERT INTO sync_checkpoint (name, last_change_id) VALUES (?, ?) "
                        + "ON CONFLICT (name) DO UPDATE SET last_change_id = EXCLUDED.last_change_id")) {
            ps.setString(1, CHECKPOINT_NAME);
            ps.setLong(2, changeId);
            ps.executeUpdate();
        }
    }
 
    // ---------------------------------------------------------------- applying one change
 
    private void apply(Connection dst, Change c) throws SQLException {
        String table = c.table();
        if (table == null) {
            throw new SQLException("Change has no table_name");
        }
        String lower = table.toLowerCase();
        if (lower.equals("login_details") || lower.startsWith("sync_")) {
            return; // never synced
        }
        if (!SAFE_NAME.matcher(table).matches()) {
            throw new SQLException("Unsafe table name: " + table);
        }
 
        String key = c.key();
        if (key == null || !key.trim().startsWith("{")) {
            throw new SQLException("record_key is not JSON (expected the full row as JSON). Value starts with: "
                    + (key == null ? "null" : key.substring(0, Math.min(60, key.length()))));
        }
 
        TableInfo info = tableInfo(dst, table);
        if (info.pkColumns().size() != 1) {
            throw new SQLException("Table " + table + " needs exactly one primary key column, found "
                    + info.pkColumns());
        }
        String pk = info.pkColumns().get(0);
 
        String pkValue = jsonField(dst, key, pk);
        if (pkValue == null) {
            throw new SQLException("record_key has no value for primary key '" + pk + "' in table " + table);
        }
 
        boolean tracked = isTracked(dst, table, pkValue);
 
        switch (c.op() == null ? "" : c.op().toUpperCase()) {
            case "INSERT" -> {
                if (tracked) {
                    return; // already copied (e.g. replay)
                }
                if (rowExists(dst, table, pk, key)) {
                    log.warn("Skipped INSERT: {} id {} already exists in destination (created there directly). "
                            + "Not overwritten.", table, pkValue);
                    return;
                }
                execJson(dst, "INSERT INTO " + q(table) + " SELECT * FROM json_populate_record(null::"
                        + q(table) + ", ?::json)", key);
                track(dst, table, pkValue, c.id());
                bumpSequence(dst, table, pk);
            }
            case "UPDATE" -> {
                if (!tracked) {
                    return; // not a row we copied: never touch destination-only rows
                }
                List<String> setCols = new ArrayList<>();
                for (String col : info.columns()) {
                    if (!col.equals(pk)) {
                        setCols.add(q(col) + " = r." + q(col));
                    }
                }
                if (setCols.isEmpty()) {
                    return;
                }
                execJson(dst, "UPDATE " + q(table) + " d SET " + String.join(", ", setCols)
                        + " FROM json_populate_record(null::" + q(table) + ", ?::json) r"
                        + " WHERE d." + q(pk) + " = r." + q(pk), key);
            }
            case "DELETE" -> {
                if (!tracked) {
                    return; // not a row we copied: never delete destination-only rows
                }
                execJson(dst, "DELETE FROM " + q(table) + " d USING json_populate_record(null::"
                        + q(table) + ", ?::json) r WHERE d." + q(pk) + " = r." + q(pk), key);
                untrack(dst, table, pkValue);
            }
            default -> throw new SQLException("Unknown operation_type: " + c.op());
        }
    }
 
    // ---------------------------------------------------------------- helpers
 
    private TableInfo tableInfo(Connection dst, String table) throws SQLException {
        TableInfo cached = tableCache.get(table);
        if (cached != null) {
            return cached;
        }
        List<String> columns = new ArrayList<>();
        try (ResultSet rs = dst.getMetaData().getColumns(null, "public", table, null)) {
            while (rs.next()) {
                if (table.equals(rs.getString("TABLE_NAME"))) { // '_' is a wildcard in the pattern, so re-check
                    columns.add(rs.getString("COLUMN_NAME"));
                }
            }
        }
        if (columns.isEmpty()) {
            throw new SQLException("Table '" + table + "' not found in destination database");
        }
        List<String> pks = new ArrayList<>();
        try (ResultSet rs = dst.getMetaData().getPrimaryKeys(null, "public", table)) {
            while (rs.next()) {
                pks.add(rs.getString("COLUMN_NAME"));
            }
        }
        TableInfo info = new TableInfo(columns, pks);
        tableCache.put(table, info);
        return info;
    }
 
    private String jsonField(Connection c, String json, String field) throws SQLException {
        try (PreparedStatement ps = c.prepareStatement("SELECT (?::json) ->> (?::text)")) {
            ps.setString(1, json);
            ps.setString(2, field);
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                return rs.getString(1);
            }
        }
    }
 
    private boolean rowExists(Connection dst, String table, String pk, String json) throws SQLException {
        String sql = "SELECT 1 FROM " + q(table) + " x JOIN json_populate_record(null::" + q(table)
                + ", ?::json) r ON x." + q(pk) + " = r." + q(pk);
        try (PreparedStatement ps = dst.prepareStatement(sql)) {
            ps.setString(1, json);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }
 
    private int execJson(Connection dst, String sql, String json) throws SQLException {
        try (PreparedStatement ps = dst.prepareStatement(sql)) {
            ps.setString(1, json);
            return ps.executeUpdate();
        }
    }
 
    private boolean isTracked(Connection dst, String table, String pkValue) throws SQLException {
        try (PreparedStatement ps = dst.prepareStatement(
                "SELECT 1 FROM sync_source_records WHERE table_name = ? AND source_record_id = ?")) {
            ps.setString(1, table);
            ps.setString(2, pkValue);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }
 
    private void track(Connection dst, String table, String pkValue, long changeId) throws SQLException {
        try (PreparedStatement ps = dst.prepareStatement(
                "INSERT INTO sync_source_records (table_name, source_record_id, source_change_id, synced_at) "
                        + "VALUES (?, ?, ?, NOW())")) {
            ps.setString(1, table);
            ps.setString(2, pkValue);
            ps.setLong(3, changeId);
            ps.executeUpdate();
        }
    }
 
    private void untrack(Connection dst, String table, String pkValue) throws SQLException {
        try (PreparedStatement ps = dst.prepareStatement(
                "DELETE FROM sync_source_records WHERE table_name = ? AND source_record_id = ?")) {
            ps.setString(1, table);
            ps.setString(2, pkValue);
            ps.executeUpdate();
        }
    }
 
    /**
     * After copying a row with an explicit id, move the destination's id counter past it,
     * so rows your website creates later in save_db_1 don't reuse a copied id.
     */
    private void bumpSequence(Connection dst, String table, String pk) throws SQLException {
        String seq = null;
        try (PreparedStatement ps = dst.prepareStatement("SELECT pg_get_serial_sequence(?, ?)")) {
            ps.setString(1, q(table));
            ps.setString(2, pk);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    seq = rs.getString(1);
                }
            }
        }
        if (seq == null) {
            return; // no sequence on this key (e.g. UUID or manually assigned ids)
        }
        long max;
        try (Statement st = dst.createStatement();
             ResultSet rs = st.executeQuery("SELECT COALESCE(MAX(" + q(pk) + "), 0) FROM " + q(table))) {
            rs.next();
            max = rs.getLong(1);
        }
        long lastValue;
        try (Statement st = dst.createStatement();
             ResultSet rs = st.executeQuery("SELECT last_value FROM " + seq)) {
            rs.next();
            lastValue = rs.getLong(1);
        }
        if (max >= lastValue && max > 0) {
            try (PreparedStatement ps = dst.prepareStatement("SELECT setval(?::regclass, ?)")) {
                ps.setString(1, seq);
                ps.setLong(2, max);
                ps.executeQuery().close();
            }
        }
    }
 
    private static String q(String identifier) {
        return "\"" + identifier.replace("\"", "\"\"") + "\"";
    }
}
