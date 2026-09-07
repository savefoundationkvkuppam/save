package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "add_users")
public class AddUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fedCode;
    private String userCode;
    private String name;

    // Store password as a SHA-256 hash, not plain text.
    private String passwordHash;

    private String role;
    private String status;
    private String cluster;

    public AddUser() {}

    public Long getId() { return id; }

    public String getFedCode() { return fedCode; }
    public void setFedCode(String value) { this.fedCode = value; }

    public String getUserCode() { return userCode; }
    public void setUserCode(String value) { this.userCode = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String value) { this.passwordHash = value; }

    public String getRole() { return role; }
    public void setRole(String value) { this.role = value; }

    public String getStatus() { return status; }
    public void setStatus(String value) { this.status = value; }

    public String getCluster() { return cluster; }
    public void setCluster(String value) { this.cluster = value; }
}

