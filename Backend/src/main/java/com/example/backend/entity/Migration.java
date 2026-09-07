package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "migrations")
public class Migration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long memberId;

    private String memberName;

    private String familyMember;

    private String placeOfMigration;

    private String natureOfOccupation;

    private String periodOfMigration;

    private String monthlyIncome;

    public Migration() {
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

    public String getPlaceOfMigration() {
        return placeOfMigration;
    }

    public void setPlaceOfMigration(String placeOfMigration) {
        this.placeOfMigration = placeOfMigration;
    }

    public String getNatureOfOccupation() {
        return natureOfOccupation;
    }

    public void setNatureOfOccupation(String natureOfOccupation) {
        this.natureOfOccupation = natureOfOccupation;
    }

    public String getPeriodOfMigration() {
        return periodOfMigration;
    }

    public void setPeriodOfMigration(String periodOfMigration) {
        this.periodOfMigration = periodOfMigration;
    }

    public String getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(String monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }
}
