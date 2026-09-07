package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "healths")
public class Health {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long memberId;
    private String memberName;
    private String familyMember;
    private String chronicIllness;
    private String hospitalReferred;
    private String alcoholism;
    private String addictionYears;
    private String differentlyAbled;
    private String disabilityCard;
    private String transgender;

    public Health() {
    }

    public Long getId() { return id; }
    public Long getMemberId() { return memberId; }
    public void setMemberId(Long memberId) { this.memberId = memberId; }
    public String getMemberName() { return memberName; }
    public void setMemberName(String memberName) { this.memberName = memberName; }
    public String getFamilyMember() { return familyMember; }
    public void setFamilyMember(String familyMember) { this.familyMember = familyMember; }
    public String getChronicIllness() { return chronicIllness; }
    public void setChronicIllness(String chronicIllness) { this.chronicIllness = chronicIllness; }
    public String getHospitalReferred() { return hospitalReferred; }
    public void setHospitalReferred(String hospitalReferred) { this.hospitalReferred = hospitalReferred; }
    public String getAlcoholism() { return alcoholism; }
    public void setAlcoholism(String alcoholism) { this.alcoholism = alcoholism; }
    public String getAddictionYears() { return addictionYears; }
    public void setAddictionYears(String addictionYears) { this.addictionYears = addictionYears; }
    public String getDifferentlyAbled() { return differentlyAbled; }
    public void setDifferentlyAbled(String differentlyAbled) { this.differentlyAbled = differentlyAbled; }
    public String getDisabilityCard() { return disabilityCard; }
    public void setDisabilityCard(String disabilityCard) { this.disabilityCard = disabilityCard; }
    public String getTransgender() { return transgender; }
    public void setTransgender(String transgender) { this.transgender = transgender; }
}

