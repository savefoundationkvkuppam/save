package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "auto_journal_locks")
public class AutoJournalLock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vazhvathramCode;
    private String month;

    @Column(nullable = false)
    private String passwordHash;

    private boolean locked;

    public AutoJournalLock() {}

    public Long getId() { return id; }
    public String getVazhvathramCode() { return vazhvathramCode; }
    public void setVazhvathramCode(String value) { vazhvathramCode = value; }
    public String getMonth() { return month; }
    public void setMonth(String value) { month = value; }
    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String value) { passwordHash = value; }
    public boolean isLocked() { return locked; }
    public void setLocked(boolean value) { locked = value; }
}
