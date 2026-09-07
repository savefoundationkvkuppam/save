package com.example.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "temp_journal_locks")
public class TempJournalLock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vazhvathramCode;
    private String month;
    private boolean locked;
    private LocalDateTime lockedAt;

    @Column(length = 128)
    private String passwordHash;

    public TempJournalLock() {}

    public Long getId() { return id; }
    public String getVazhvathramCode() { return vazhvathramCode; }
    public void setVazhvathramCode(String value) { vazhvathramCode = value; }
    public String getMonth() { return month; }
    public void setMonth(String value) { month = value; }
    public boolean isLocked() { return locked; }
    public void setLocked(boolean value) { locked = value; }
    public LocalDateTime getLockedAt() { return lockedAt; }
    public void setLockedAt(LocalDateTime value) { lockedAt = value; }
    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String value) { passwordHash = value; }
}
