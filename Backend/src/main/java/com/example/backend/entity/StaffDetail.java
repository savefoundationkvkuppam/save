package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "staff_details")
public class StaffDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fedCode;
    private String code;
    private String staffName;
    private String mlLeaveCode;
    private String role;
    private String dhanFedStaff;

    public StaffDetail() {}

    public Long getId() { return id; }
    public String getFedCode() { return fedCode; }
    public void setFedCode(String value) { this.fedCode = value; }
    public String getCode() { return code; }
    public void setCode(String value) { this.code = value; }
    public String getStaffName() { return staffName; }
    public void setStaffName(String value) { this.staffName = value; }
    public String getMlLeaveCode() { return mlLeaveCode; }
    public void setMlLeaveCode(String value) { this.mlLeaveCode = value; }
    public String getRole() { return role; }
    public void setRole(String value) { this.role = value; }
    public String getDhanFedStaff() { return dhanFedStaff; }
    public void setDhanFedStaff(String value) { this.dhanFedStaff = value; }
}

