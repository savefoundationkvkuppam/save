package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "login_details")
public class LoginDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String locationName;
    private String blockCode;
    private String role;
    private String dataEntryEdit;
    private String program;
    private String userId;
    private String password;

    public LoginDetails() {
    }

    public Long getId() {
        return id;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getBlockCode() {
        return blockCode;
    }

    public void setBlockCode(String blockCode) {
        this.blockCode = blockCode;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDataEntryEdit() {
        return dataEntryEdit;
    }

    public void setDataEntryEdit(String dataEntryEdit) {
        this.dataEntryEdit = dataEntryEdit;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}