package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "panchayat_unions")
public class PanchayatUnion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String panchayatUnionCode;
    private String districtName;
    private String talukName;
    private String panchayatUnionName;

    public PanchayatUnion() {
    }

    public Long getId() {
        return id;
    }

    public String getPanchayatUnionCode() {
        return panchayatUnionCode;
    }

    public void setPanchayatUnionCode(String panchayatUnionCode) {
        this.panchayatUnionCode = panchayatUnionCode;
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

    public String getPanchayatUnionName() {
        return panchayatUnionName;
    }

    public void setPanchayatUnionName(String panchayatUnionName) {
        this.panchayatUnionName = panchayatUnionName;
    }
}