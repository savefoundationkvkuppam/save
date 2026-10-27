package com.example.backend.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class DatabaseSyncService {

    private final JdbcTemplate targetJdbc;

    public DatabaseSyncService(
            @Qualifier("secondaryJdbcTemplate")
            JdbcTemplate secondaryJdbc) {
        this.targetJdbc = secondaryJdbc;
    }

    @Scheduled(
        fixedDelay = 60000,
        initialDelay = 15000
    )
    public void testDestinationConnection() {
        try {
            String databaseName = targetJdbc.queryForObject(
                "SELECT current_database()",
                String.class
            );

            System.out.println(
                "SYNC CONNECTION TEST: Connected to " + databaseName
            );

        } catch (Exception e) {
            System.err.println(
                "SYNC CONNECTION TEST FAILED: " + e.getMessage()
            );
        }
    }
}
