package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "entitlements")
public class Entitlement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long memberId;
    private String memberName;
    private String familyMember;
    private String voterIdCard;
    private String bankAccount;
    private String aadharCard;
    private String rationCard;
    private String drivingLicense;
    private String esiCard;
    private String kissanCard;
    private String govtHealthCard;
    private String oap;
    private String widowPension;
    private String marriageScheme;
    private String abiy;
    private String pmjjby;
    private String pmjsby;
    private String microPension;
    private String healthInsurance;
    private String atalPension;
    private String mgnrega;
    private String labourCard;
    private String houseScheme;
    private String vendorLicense;
    private String others;

    public Entitlement() {}

    public Long getId() { return id; }
    public Long getMemberId() { return memberId; }
    public void setMemberId(Long memberId) { this.memberId = memberId; }
    public String getMemberName() { return memberName; }
    public void setMemberName(String memberName) { this.memberName = memberName; }
    public String getFamilyMember() { return familyMember; }
    public void setFamilyMember(String familyMember) { this.familyMember = familyMember; }
    public String getVoterIdCard() { return voterIdCard; }
    public void setVoterIdCard(String value) { this.voterIdCard = value; }
    public String getBankAccount() { return bankAccount; }
    public void setBankAccount(String value) { this.bankAccount = value; }
    public String getAadharCard() { return aadharCard; }
    public void setAadharCard(String value) { this.aadharCard = value; }
    public String getRationCard() { return rationCard; }
    public void setRationCard(String value) { this.rationCard = value; }
    public String getDrivingLicense() { return drivingLicense; }
    public void setDrivingLicense(String value) { this.drivingLicense = value; }
    public String getEsiCard() { return esiCard; }
    public void setEsiCard(String value) { this.esiCard = value; }
    public String getKissanCard() { return kissanCard; }
    public void setKissanCard(String value) { this.kissanCard = value; }
    public String getGovtHealthCard() { return govtHealthCard; }
    public void setGovtHealthCard(String value) { this.govtHealthCard = value; }
    public String getOap() { return oap; }
    public void setOap(String value) { this.oap = value; }
    public String getWidowPension() { return widowPension; }
    public void setWidowPension(String value) { this.widowPension = value; }
    public String getMarriageScheme() { return marriageScheme; }
    public void setMarriageScheme(String value) { this.marriageScheme = value; }
    public String getAbiy() { return abiy; }
    public void setAbiy(String value) { this.abiy = value; }
    public String getPmjjby() { return pmjjby; }
    public void setPmjjby(String value) { this.pmjjby = value; }
    public String getPmjsby() { return pmjsby; }
    public void setPmjsby(String value) { this.pmjsby = value; }
    public String getMicroPension() { return microPension; }
    public void setMicroPension(String value) { this.microPension = value; }
    public String getHealthInsurance() { return healthInsurance; }
    public void setHealthInsurance(String value) { this.healthInsurance = value; }
    public String getAtalPension() { return atalPension; }
    public void setAtalPension(String value) { this.atalPension = value; }
    public String getMgnrega() { return mgnrega; }
    public void setMgnrega(String value) { this.mgnrega = value; }
    public String getLabourCard() { return labourCard; }
    public void setLabourCard(String value) { this.labourCard = value; }
    public String getHouseScheme() { return houseScheme; }
    public void setHouseScheme(String value) { this.houseScheme = value; }
    public String getVendorLicense() { return vendorLicense; }
    public void setVendorLicense(String value) { this.vendorLicense = value; }
    public String getOthers() { return others; }
    public void setOthers(String value) { this.others = value; }
}

