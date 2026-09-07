package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "panchayats")
public class Panchayat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String panchayatUnionName;
    private String panchayatWard;
    private String code;
    private String name;

    public Panchayat() {
    }

    public Long getId() {
        return id;
    }

    public String getPanchayatUnionName() {
        return panchayatUnionName;
    }

    public void setPanchayatUnionName(String panchayatUnionName) {
        this.panchayatUnionName = panchayatUnionName;
    }

    public String getPanchayatWard() {
        return panchayatWard;
    }

    public void setPanchayatWard(String panchayatWard) {
        this.panchayatWard = panchayatWard;
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
}