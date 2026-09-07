package com.example.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction_locks")
public class TransactionLock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vazhvathramCode;
    private String month;
    private String attendanceDate;
    private String receiptDate;
    private boolean locked;
    private LocalDateTime lockedAt;

    @Column(length = 128)
    private String passwordHash;

    public TransactionLock() {}

    public Long getId() { return id; }
    public String getVazhvathramCode() { return vazhvathramCode; }
    public void setVazhvathramCode(String value) { vazhvathramCode = value; }
    public String getMonth() { return month; }
    public void setMonth(String value) { month = value; }
    public String getAttendanceDate() { return attendanceDate; }
    public void setAttendanceDate(String value) { attendanceDate = value; }
    public String getReceiptDate() { return receiptDate; }
    public void setReceiptDate(String value) { receiptDate = value; }
    public boolean isLocked() { return locked; }
    public void setLocked(boolean value) { locked = value; }
    public LocalDateTime getLockedAt() { return lockedAt; }
    public void setLockedAt(LocalDateTime value) { lockedAt = value; }
    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String value) { passwordHash = value; }
}
