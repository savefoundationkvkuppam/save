package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "pan_unions")
public class PanUnion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String panUnionCode;
    private String districtName;
    private String panUnionName;

    public PanUnion() {
    }

    public Long getId() {
        return id;
    }

    public String getPanUnionCode() {
        return panUnionCode;
    }

    public void setPanUnionCode(String panUnionCode) {
        this.panUnionCode = panUnionCode;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getPanUnionName() {
        return panUnionName;
    }

    public void setPanUnionName(String panUnionName) {
        this.panUnionName = panUnionName;
    }
}