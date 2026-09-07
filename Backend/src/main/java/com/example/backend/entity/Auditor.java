package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "auditors")
public class Auditor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String auditorName;
    private String address1;
    private String address2;
    private String state;
    private String district;
    private String pincode;
    private String phone;

    public Auditor() {}

    public Long getId() { return id; }

    public String getAuditorName() { return auditorName; }
    public void setAuditorName(String value) { this.auditorName = value; }

    public String getAddress1() { return address1; }
    public void setAddress1(String value) { this.address1 = value; }

    public String getAddress2() { return address2; }
    public void setAddress2(String value) { this.address2 = value; }

    public String getState() { return state; }
    public void setState(String value) { this.state = value; }

    public String getDistrict() { return district; }
    public void setDistrict(String value) { this.district = value; }

    public String getPincode() { return pincode; }
    public void setPincode(String value) { this.pincode = value; }

    public String getPhone() { return phone; }
    public void setPhone(String value) { this.phone = value; }
}

