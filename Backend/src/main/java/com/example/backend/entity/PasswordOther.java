package com.example.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "password_others")
public class PasswordOther {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fedCode;
    private String instType;

    @Column(name = "\"user\"")
    private String user;

    // Store only a SHA-256 hash, never the plain-text password.
    private String passwordHash;

    private LocalDateTime changedAt;

    public PasswordOther() {}

    public Long getId() { return id; }

    public String getFedCode() { return fedCode; }
    public void setFedCode(String value) { this.fedCode = value; }

    public String getInstType() { return instType; }
    public void setInstType(String value) { this.instType = value; }

    public String getUser() { return user; }
    public void setUser(String value) { this.user = value; }

    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String value) { this.passwordHash = value; }

    public LocalDateTime getChangedAt() { return changedAt; }
    public void setChangedAt(LocalDateTime value) { this.changedAt = value; }
}

