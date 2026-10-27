
package com.example.backend.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class DatabaseSyncService {

    private final JdbcTemplate sourceJdbc;
    private final JdbcTemplate targetJdbc;

    public DatabaseSyncService(
            JdbcTemplate primaryJdbc,
            @Qualifier("secondaryJdbcTemplate")
            JdbcTemplate secondaryJdbc) {
        this.sourceJdbc = primaryJdbc;
        this.targetJdbc = secondaryJdbc;
    }

    @Scheduled(fixedDelay = 60000, initialDelay = 15000)
    public void checkDatabaseConnections() {
        try {
            String source = sourceJdbc.queryForObject(
                "SELECT current_database()", String.class);

            String target = targetJdbc.queryForObject(
                "SELECT current_database()", String.class);

            System.out.println(
                "SYNC CHECK: source=" + source
                + ", destination=" + target
                + ". Connections successful; data sync not yet enabled."
            );
        } catch (Exception e) {
            System.err.println(
                "SYNC CHECK FAILED: " + e.getMessage());
        }
    }
}
