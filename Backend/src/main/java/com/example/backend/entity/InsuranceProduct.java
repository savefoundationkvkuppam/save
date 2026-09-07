package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "insurance_products")
public class InsuranceProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String federationCode;
    private String ogiLifeMember;
    private String pmLifeMember;
    private String nalam;
    private String pmHealth;
    private String ogiLifeSpouse;
    private String pmLifeSpouse;
    private String pmCow;
    private String pmGoat;
    private String tataAiaMember;
    private String tataAiaSpouse;
    private String pmLifeOldAgeMember;
    private String pmLifeOldAgeSpouse;
    private String dateChange;

    public InsuranceProduct() {
    }

    public Long getId() {
        return id;
    }

    public String getFederationCode() {
        return federationCode;
    }

    public void setFederationCode(String federationCode) {
        this.federationCode = federationCode;
    }

    public String getOgiLifeMember() {
        return ogiLifeMember;
    }

    public void setOgiLifeMember(String ogiLifeMember) {
        this.ogiLifeMember = ogiLifeMember;
    }

    public String getPmLifeMember() {
        return pmLifeMember;
    }

    public void setPmLifeMember(String pmLifeMember) {
        this.pmLifeMember = pmLifeMember;
    }

    public String getNalam() {
        return nalam;
    }

    public void setNalam(String nalam) {
        this.nalam = nalam;
    }

    public String getPmHealth() {
        return pmHealth;
    }

    public void setPmHealth(String pmHealth) {
        this.pmHealth = pmHealth;
    }

    public String getOgiLifeSpouse() {
        return ogiLifeSpouse;
    }

    public void setOgiLifeSpouse(String ogiLifeSpouse) {
        this.ogiLifeSpouse = ogiLifeSpouse;
    }

    public String getPmLifeSpouse() {
        return pmLifeSpouse;
    }

    public void setPmLifeSpouse(String pmLifeSpouse) {
        this.pmLifeSpouse = pmLifeSpouse;
    }

    public String getPmCow() {
        return pmCow;
    }

    public void setPmCow(String pmCow) {
        this.pmCow = pmCow;
    }

    public String getPmGoat() {
        return pmGoat;
    }

    public void setPmGoat(String pmGoat) {
        this.pmGoat = pmGoat;
    }

    public String getTataAiaMember() {
        return tataAiaMember;
    }

    public void setTataAiaMember(String tataAiaMember) {
        this.tataAiaMember = tataAiaMember;
    }

    public String getTataAiaSpouse() {
        return tataAiaSpouse;
    }

    public void setTataAiaSpouse(String tataAiaSpouse) {
        this.tataAiaSpouse = tataAiaSpouse;
    }

    public String getPmLifeOldAgeMember() {
        return pmLifeOldAgeMember;
    }

    public void setPmLifeOldAgeMember(String pmLifeOldAgeMember) {
        this.pmLifeOldAgeMember = pmLifeOldAgeMember;
    }

    public String getPmLifeOldAgeSpouse() {
        return pmLifeOldAgeSpouse;
    }

    public void setPmLifeOldAgeSpouse(String pmLifeOldAgeSpouse) {
        this.pmLifeOldAgeSpouse = pmLifeOldAgeSpouse;
    }

    public String getDateChange() {
        return dateChange;
    }

    public void setDateChange(String dateChange) {
        this.dateChange = dateChange;
    }
}