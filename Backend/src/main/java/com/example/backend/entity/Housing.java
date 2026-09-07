package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "housings")
public class Housing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long memberId;
    private String memberName;
    private String typeOfHouse;
    private String ownership;
    private String rentAmount;
    private String rentAdvance;
    private String leaseAmount;
    private String constructionYear;
    private String houseValue;
    private String housePattaName;
    private String toiletFacility;
    private String toiletFacilitySpace;
    private String usageOfToilet;
    private String undergroundDrainage;
    private String electricity;
    private String tapWaterConnection;
    private String drinkingWaterSource;
    private String waterFilter;
    private String roofWaterHarvesting;
    private String kitchenGardenSpace;
    private String housePlotPatta;
    private String housePlotArea;
    private String plotValue;
    private String plotPattaName;

    public Housing() {}

    public Long getId() { return id; }
    public Long getMemberId() { return memberId; }
    public void setMemberId(Long memberId) { this.memberId = memberId; }
    public String getMemberName() { return memberName; }
    public void setMemberName(String memberName) { this.memberName = memberName; }
    public String getTypeOfHouse() { return typeOfHouse; }
    public void setTypeOfHouse(String typeOfHouse) { this.typeOfHouse = typeOfHouse; }
    public String getOwnership() { return ownership; }
    public void setOwnership(String ownership) { this.ownership = ownership; }
    public String getRentAmount() { return rentAmount; }
    public void setRentAmount(String rentAmount) { this.rentAmount = rentAmount; }
    public String getRentAdvance() { return rentAdvance; }
    public void setRentAdvance(String rentAdvance) { this.rentAdvance = rentAdvance; }
    public String getLeaseAmount() { return leaseAmount; }
    public void setLeaseAmount(String leaseAmount) { this.leaseAmount = leaseAmount; }
    public String getConstructionYear() { return constructionYear; }
    public void setConstructionYear(String constructionYear) { this.constructionYear = constructionYear; }
    public String getHouseValue() { return houseValue; }
    public void setHouseValue(String houseValue) { this.houseValue = houseValue; }
    public String getHousePattaName() { return housePattaName; }
    public void setHousePattaName(String housePattaName) { this.housePattaName = housePattaName; }
    public String getToiletFacility() { return toiletFacility; }
    public void setToiletFacility(String toiletFacility) { this.toiletFacility = toiletFacility; }
    public String getToiletFacilitySpace() { return toiletFacilitySpace; }
    public void setToiletFacilitySpace(String toiletFacilitySpace) { this.toiletFacilitySpace = toiletFacilitySpace; }
    public String getUsageOfToilet() { return usageOfToilet; }
    public void setUsageOfToilet(String usageOfToilet) { this.usageOfToilet = usageOfToilet; }
    public String getUndergroundDrainage() { return undergroundDrainage; }
    public void setUndergroundDrainage(String undergroundDrainage) { this.undergroundDrainage = undergroundDrainage; }
    public String getElectricity() { return electricity; }
    public void setElectricity(String electricity) { this.electricity = electricity; }
    public String getTapWaterConnection() { return tapWaterConnection; }
    public void setTapWaterConnection(String tapWaterConnection) { this.tapWaterConnection = tapWaterConnection; }
    public String getDrinkingWaterSource() { return drinkingWaterSource; }
    public void setDrinkingWaterSource(String drinkingWaterSource) { this.drinkingWaterSource = drinkingWaterSource; }
    public String getWaterFilter() { return waterFilter; }
    public void setWaterFilter(String waterFilter) { this.waterFilter = waterFilter; }
    public String getRoofWaterHarvesting() { return roofWaterHarvesting; }
    public void setRoofWaterHarvesting(String roofWaterHarvesting) { this.roofWaterHarvesting = roofWaterHarvesting; }
    public String getKitchenGardenSpace() { return kitchenGardenSpace; }
    public void setKitchenGardenSpace(String kitchenGardenSpace) { this.kitchenGardenSpace = kitchenGardenSpace; }
    public String getHousePlotPatta() { return housePlotPatta; }
    public void setHousePlotPatta(String housePlotPatta) { this.housePlotPatta = housePlotPatta; }
    public String getHousePlotArea() { return housePlotArea; }
    public void setHousePlotArea(String housePlotArea) { this.housePlotArea = housePlotArea; }
    public String getPlotValue() { return plotValue; }
    public void setPlotValue(String plotValue) { this.plotValue = plotValue; }
    public String getPlotPattaName() { return plotPattaName; }
    public void setPlotPattaName(String plotPattaName) { this.plotPattaName = plotPattaName; }
}
