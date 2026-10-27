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

    @Scheduled(fixedDelay = 60000)
    public void checkForChanges() {
        // Synchronization logic will be added after
        // the source-to-destination mapping is configured.
    }
}
