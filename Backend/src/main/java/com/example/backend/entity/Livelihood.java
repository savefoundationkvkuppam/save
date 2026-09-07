package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "livelihoods")
public class Livelihood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long memberId;

    private String memberName;

    private String familyMember;

    private String masterOccupation;

    private String primaryOccupation;

    private String primaryMonthlyIncome;

    private String secondaryMasterOccupation;

    private String secondaryOccupation;

    private String secondaryMonthlyIncome;

    private String totalIncome;

    public Livelihood() {
    }

    public Long getId() {
        return id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getFamilyMember() {
        return familyMember;
    }

    public void setFamilyMember(String familyMember) {
        this.familyMember = familyMember;
    }

    public String getMasterOccupation() {
        return masterOccupation;
    }

    public void setMasterOccupation(String masterOccupation) {
        this.masterOccupation = masterOccupation;
    }

    public String getPrimaryOccupation() {
        return primaryOccupation;
    }

    public void setPrimaryOccupation(String primaryOccupation) {
        this.primaryOccupation = primaryOccupation;
    }

    public String getPrimaryMonthlyIncome() {
        return primaryMonthlyIncome;
    }

    public void setPrimaryMonthlyIncome(String primaryMonthlyIncome) {
        this.primaryMonthlyIncome = primaryMonthlyIncome;
    }

    public String getSecondaryMasterOccupation() {
        return secondaryMasterOccupation;
    }

    public void setSecondaryMasterOccupation(String secondaryMasterOccupation) {
        this.secondaryMasterOccupation = secondaryMasterOccupation;
    }

    public String getSecondaryOccupation() {
        return secondaryOccupation;
    }

    public void setSecondaryOccupation(String secondaryOccupation) {
        this.secondaryOccupation = secondaryOccupation;
    }

    public String getSecondaryMonthlyIncome() {
        return secondaryMonthlyIncome;
    }

    public void setSecondaryMonthlyIncome(String secondaryMonthlyIncome) {
        this.secondaryMonthlyIncome = secondaryMonthlyIncome;
    }

    public String getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(String totalIncome) {
        this.totalIncome = totalIncome;
    }
}