package com.example.backend.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

@Service
public class DatabaseSyncService {

private final DataSource sourceDataSource;  // save_db_2
    private final DataSource destDataSource;    // save_db_1
    
    private long lastProcessedId = 0;

public DatabaseSyncService(
            @Qualifier("sourceDataSource") DataSource sourceDataSource,
            @Qualifier("destDataSource") DataSource destDataSource) {
        this.sourceDataSource = sourceDataSource;
        this.destDataSource = destDataSource;
    }

@Scheduled(fixedRate = 60000) // Run every 60 seconds
    @Transactional
    public void syncDatabases() {
        try {
            processChanges();
        } catch (Exception e) {
            System.err.println("Sync failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

private void processChanges() throws SQLException {
        Connection sourceConn = sourceDataSource.getConnection();
        Connection destConn = destDataSource.getConnection();

try {
            // Get unprocessed changes from save_db_2
            String query = "SELECT id, table_name, operation_type, record_key, changed_at " +
                          "FROM sync_change_log WHERE id > ? ORDER BY id ASC LIMIT 100";
            
            PreparedStatement stmt = sourceConn.prepareStatement(query);
            stmt.setLong(1, lastProcessedId);
            ResultSet rs = stmt.executeQuery();

while (rs.next()) {
                long changeId = rs.getLong("id");
                String tableName = rs.getString("table_name");
                String operation = rs.getString("operation_type");
                String recordKey = rs.getString("record_key");

// Skip login_details table
                if ("login_details".equalsIgnoreCase(tableName)) {
                    lastProcessedId = changeId;
                    continue;
                }

try {
                    switch (operation) {
                        case "INSERT":
                            handleInsert(destConn, tableName, recordKey, changeId);
                            break;
                        case "UPDATE":
                            handleUpdate(destConn, tableName, recordKey, changeId);
                            break;
                        case "DELETE":
                            handleDelete(destConn, tableName, recordKey, changeId);
                            break;
                    }
                    lastProcessedId = changeId;
                } catch (Exception e) {
                    System.err.println("Failed to process change " + changeId + ": " + e.getMessage());
                }
            }
        } finally {
            sourceConn.close();
            destConn.close();
        }
    }

private void handleInsert(Connection destConn, String tableName, String recordKey, long changeId) throws SQLException {
        // Parse record_key to get primary key value
        String pkValue = extractPrimaryKeyValue(recordKey);
        
        // Check if already synced
        if (isAlreadySynced(destConn, tableName, pkValue)) {
            return;
        }

// Get full record from source
        Map<String, Object> record = parseRecordKey(recordKey);
        
        // Build INSERT statement
        StringBuilder columns = new StringBuilder();
        StringBuilder values = new StringBuilder();
        List<Object> params = new ArrayList<>();

for (Map.Entry<String, Object> entry : record.entrySet()) {
            if (columns.length() > 0) {
                columns.append(", ");
                values.append(", ");
            }
            columns.append(entry.getKey());
            values.append("?");
            params.add(entry.getValue());
        }

String sql = "INSERT INTO " + tableName + " (" + columns + ") VALUES (" + values + ")";
        PreparedStatement stmt = destConn.prepareStatement(sql);
        
        for (int i = 0; i < params.size(); i++) {
            stmt.setObject(i + 1, params.get(i));
        }
        
        stmt.executeUpdate();
        
        // Record sync
        recordSync(destConn, tableName, pkValue, changeId);
    }

private void handleUpdate(Connection destConn, String tableName, String recordKey, long changeId) throws SQLException {
        String pkValue = extractPrimaryKeyValue(recordKey);
        
        // Only update if this record was synced from source
        if (!isAlreadySynced(destConn, tableName, pkValue)) {
            return; // Don't update records created directly in destination
        }

Map<String, Object> record = parseRecordKey(recordKey);
        
        StringBuilder setClause = new StringBuilder();
        List<Object> params = new ArrayList<>();

for (Map.Entry<String, Object> entry : record.entrySet()) {
            if (!entry.getKey().equals("id")) { // Don't update primary key
                if (setClause.length() > 0) {
                    setClause.append(", ");
                }
                setClause.append(entry.getKey()).append(" = ?");
                params.add(entry.getValue());
            }
        }

params.add(pkValue);
        
        String sql = "UPDATE " + tableName + " SET " + setClause + " WHERE id = ?";
        PreparedStatement stmt = destConn.prepareStatement(sql);
        
        for (int i = 0; i < params.size(); i++) {
            stmt.setObject(i + 1, params.get(i));
        }
        
        stmt.executeUpdate();
    }

private void handleDelete(Connection destConn, String tableName, String recordKey, long changeId) throws SQLException {
        String pkValue = extractPrimaryKeyValue(recordKey);
        
        // Only delete if this record was synced from source
        if (!isAlreadySynced(destConn, tableName, pkValue)) {
            return; // Don't delete records created directly in destination
        }

String sql = "DELETE FROM " + tableName + " WHERE id = ?";
        PreparedStatement stmt = destConn.prepareStatement(sql);
        stmt.setString(1, pkValue);
        stmt.executeUpdate();
        
        // Remove from sync tracking
        removeSync(destConn, tableName, pkValue);
    }

private boolean isAlreadySynced(Connection conn, String tableName, String recordId) throws SQLException {
        String sql = "SELECT COUNT(*) FROM sync_source_records WHERE table_name = ? AND source_record_id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, tableName);
        stmt.setString(2, recordId);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        return rs.getInt(1) > 0;
    }

private void recordSync(Connection conn, String tableName, String recordId, long changeId) throws SQLException {
        String sql = "INSERT INTO sync_source_records (table_name, source_record_id, source_change_id, synced_at) VALUES (?, ?, ?, NOW())";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, tableName);
        stmt.setString(2, recordId);
        stmt.setLong(3, changeId);
        stmt.executeUpdate();
    }

private void removeSync(Connection conn, String tableName, String recordId) throws SQLException {
        String sql = "DELETE FROM sync_source_records WHERE table_name = ? AND source_record_id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, tableName);
        stmt.setString(2, recordId);
        stmt.executeUpdate();
    }

private String extractPrimaryKeyValue(String recordKey) {
        // recordKey format: "id=123,name=John,..." 
        // Extract id value
        String[] pairs = recordKey.split(",");
        for (String pair : pairs) {
            String[] kv = pair.trim().split("=");
            if (kv.length == 2 && kv[0].equals("id")) {
                return kv[1];
            }
        }
        return null;
    }

private Map<String, Object> parseRecordKey(String recordKey) {
        Map<String, Object> record = new HashMap<>();
        String[] pairs = recordKey.split(",");
        for (String pair : pairs) {
            String[] kv = pair.trim().split("=", 2);
            if (kv.length == 2) {
                record.put(kv[0], kv[1]);
            }
        }
        return record;
    }
}
