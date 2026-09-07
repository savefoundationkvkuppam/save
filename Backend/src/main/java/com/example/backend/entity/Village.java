package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "villages")
public class Village {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String panchayatName;
    private String villageSlum;
    private String code;
    private String name;
    private String pinCode;

    public Village() {
    }

    public Long getId() {
        return id;
    }

    public String getPanchayatName() {
        return panchayatName;
    }

    public void setPanchayatName(String panchayatName) {
        this.panchayatName = panchayatName;
    }

    public String getVillageSlum() {
        return villageSlum;
    }

    public void setVillageSlum(String villageSlum) {
        this.villageSlum = villageSlum;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }
}