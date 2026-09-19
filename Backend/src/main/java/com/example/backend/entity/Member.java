package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String memberCode;
    private String memberName;
    private String vazhvathramCode;
    private String regionalMemberName;
    private String clusterName;
    private String vazhvathramName;
    private String designation;
    private String date;
    private String dateOfJoining;
    private String yearOfBirth;
    private String maritalStatus;
    private String husbandFatherName;
    private String aliveStatus;

    private String category;
    private String familyCategory;
    private String caste;

    private String rationCard;
    private String rationCardNo;

    private String voterId;
    private String spouseVoterId;

    private String aadharId;
    private String spouseAadharId;

    private String mobileNumber;
    private String spouseMobileNumber;

    private String jobCardNo;
    private String panCardNo;

    private String regularSavings;
    private String specialSavings;

    // Mem.House Det
    private String houseOwnership;

    // Member lock status used by Others -> Unlock Members
    private boolean locked = false;

    public Member() {
    }

    public Long getId() {
        return id;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }
    public String getVazhvathramCode() {
         return vazhvathramCode;
    }

    public void setVazhvathramCode(String vazhvathramCode) {
         this.vazhvathramCode = vazhvathramCode;
    }
    

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getRegionalMemberName() {
        return regionalMemberName;
    }

    public void setRegionalMemberName(String regionalMemberName) {
        this.regionalMemberName = regionalMemberName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(String dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getHusbandFatherName() {
        return husbandFatherName;
    }

    public void setHusbandFatherName(String husbandFatherName) {
        this.husbandFatherName = husbandFatherName;
    }

    public String getAliveStatus() {
        return aliveStatus;
    }

    public void setAliveStatus(String aliveStatus) {
        this.aliveStatus = aliveStatus;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFamilyCategory() {
        return familyCategory;
    }

    public void setFamilyCategory(String familyCategory) {
        this.familyCategory = familyCategory;
    }

    public String getCaste() {
        return caste;
    }

    public void setCaste(String caste) {
        this.caste = caste;
    }

    public String getRationCard() {
        return rationCard;
    }

    public void setRationCard(String rationCard) {
        this.rationCard = rationCard;
    }

    public String getRationCardNo() {
        return rationCardNo;
    }

    public void setRationCardNo(String rationCardNo) {
        this.rationCardNo = rationCardNo;
    }

    public String getVoterId() {
        return voterId;
    }

    public void setVoterId(String voterId) {
        this.voterId = voterId;
    }

    public String getSpouseVoterId() {
        return spouseVoterId;
    }

    public void setSpouseVoterId(String spouseVoterId) {
        this.spouseVoterId = spouseVoterId;
    }

    public String getAadharId() {
        return aadharId;
    }

    public void setAadharId(String aadharId) {
        this.aadharId = aadharId;
    }

    public String getSpouseAadharId() {
        return spouseAadharId;
    }

    public void setSpouseAadharId(String spouseAadharId) {
        this.spouseAadharId = spouseAadharId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getSpouseMobileNumber() {
        return spouseMobileNumber;
    }

    public void setSpouseMobileNumber(String spouseMobileNumber) {
        this.spouseMobileNumber = spouseMobileNumber;
    }

    public String getJobCardNo() {
        return jobCardNo;
    }

    public void setJobCardNo(String jobCardNo) {
        this.jobCardNo = jobCardNo;
    }

    public String getPanCardNo() {
        return panCardNo;
    }

    public void setPanCardNo(String panCardNo) {
        this.panCardNo = panCardNo;
    }

    public String getRegularSavings() {
        return regularSavings;
    }

    public void setRegularSavings(String regularSavings) {
        this.regularSavings = regularSavings;
    }

    public String getSpecialSavings() {
        return specialSavings;
    }

    public void setSpecialSavings(String specialSavings) {
        this.specialSavings = specialSavings;
    }

    public String getHouseOwnership() {
        return houseOwnership;
    }

    public void setHouseOwnership(String houseOwnership) {
        this.houseOwnership = houseOwnership;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }
}
