package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "lands")
public class Land {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long memberId;
    private String memberName;
    private String landOwnership;
    private String areaInAcre;
    private String landValue;
    private String landPatta;
    private String landName;
    private String irrigationType;
    private String crop1;
    private String crop2;
    private String yieldCrop1;
    private String yieldCrop2;
    private String marketPlace;
    private String cropInsurance;
    private String annualValue;

    public Land() {}

    public Long getId() { return id; }
    public Long getMemberId() { return memberId; }
    public void setMemberId(Long memberId) { this.memberId = memberId; }
    public String getMemberName() { return memberName; }
    public void setMemberName(String memberName) { this.memberName = memberName; }
    public String getLandOwnership() { return landOwnership; }
    public void setLandOwnership(String landOwnership) { this.landOwnership = landOwnership; }
    public String getAreaInAcre() { return areaInAcre; }
    public void setAreaInAcre(String areaInAcre) { this.areaInAcre = areaInAcre; }
    public String getLandValue() { return landValue; }
    public void setLandValue(String landValue) { this.landValue = landValue; }
    public String getLandPatta() { return landPatta; }
    public void setLandPatta(String landPatta) { this.landPatta = landPatta; }
    public String getLandName() { return landName; }
    public void setLandName(String landName) { this.landName = landName; }
    public String getIrrigationType() { return irrigationType; }
    public void setIrrigationType(String irrigationType) { this.irrigationType = irrigationType; }
    public String getCrop1() { return crop1; }
    public void setCrop1(String crop1) { this.crop1 = crop1; }
    public String getCrop2() { return crop2; }
    public void setCrop2(String crop2) { this.crop2 = crop2; }
    public String getYieldCrop1() { return yieldCrop1; }
    public void setYieldCrop1(String yieldCrop1) { this.yieldCrop1 = yieldCrop1; }
    public String getYieldCrop2() { return yieldCrop2; }
    public void setYieldCrop2(String yieldCrop2) { this.yieldCrop2 = yieldCrop2; }
    public String getMarketPlace() { return marketPlace; }
    public void setMarketPlace(String marketPlace) { this.marketPlace = marketPlace; }
    public String getCropInsurance() { return cropInsurance; }
    public void setCropInsurance(String cropInsurance) { this.cropInsurance = cropInsurance; }
    public String getAnnualValue() { return annualValue; }
    public void setAnnualValue(String annualValue) { this.annualValue = annualValue; }
}
