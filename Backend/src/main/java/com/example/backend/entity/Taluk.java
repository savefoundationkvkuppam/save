package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "taluks")
public class Taluk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String talukCode;
    private String districtName;
    private String talukName;

    public Taluk() {
    }

    public Long getId() {
        return id;
    }

    public String getTalukCode() {
        return talukCode;
    }

    public void setTalukCode(String talukCode) {
        this.talukCode = talukCode;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getTalukName() {
        return talukName;
    }

    public void setTalukName(String talukName) {
        this.talukName = talukName;
    }
}