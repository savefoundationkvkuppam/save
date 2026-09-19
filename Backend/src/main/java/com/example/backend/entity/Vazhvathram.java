package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vazhvathrams")
public class Vazhvathram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clusterName;
    private String vazhvathramCode;
    private String vazhvathramCodeSecond;
    private String vazhvathramName;
    private String regionalVazhvathramName;
    private String formationDate;
    private String qualityCheckedDate;
    private String meetingType;
    private String meetingDate;
    private String formedBy;
    private String villageName;
    private String bankName;
    private String branchName;
    private String serviceAreaBranch;

    public Vazhvathram() {
    }

    public Long getId() {
        return id;
    }
    public String getClusterName() {
    return clusterName;
    }

    public void setClusterName(String clusterName) {
    this.clusterName = clusterName;
    }

    public String getVazhvathramCode() {
        return vazhvathramCode;
    }

    public void setVazhvathramCode(String vazhvathramCode) {
        this.vazhvathramCode = vazhvathramCode;
    }

    public String getVazhvathramCodeSecond() {
        return vazhvathramCodeSecond;
    }

    public void setVazhvathramCodeSecond(String vazhvathramCodeSecond) {
        this.vazhvathramCodeSecond = vazhvathramCodeSecond;
    }

    public String getVazhvathramName() {
        return vazhvathramName;
    }

    public void setVazhvathramName(String vazhvathramName) {
        this.vazhvathramName = vazhvathramName;
    }

    public String getRegionalVazhvathramName() {
        return regionalVazhvathramName;
    }

    public void setRegionalVazhvathramName(String regionalVazhvathramName) {
        this.regionalVazhvathramName = regionalVazhvathramName;
    }

    public String getFormationDate() {
        return formationDate;
    }

    public void setFormationDate(String formationDate) {
        this.formationDate = formationDate;
    }

    public String getQualityCheckedDate() {
        return qualityCheckedDate;
    }

    public void setQualityCheckedDate(String qualityCheckedDate) {
        this.qualityCheckedDate = qualityCheckedDate;
    }

    public String getMeetingType() {
        return meetingType;
    }

    public void setMeetingType(String meetingType) {
        this.meetingType = meetingType;
    }

    public String getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(String meetingDate) {
        this.meetingDate = meetingDate;
    }

    public String getFormedBy() {
        return formedBy;
    }

    public void setFormedBy(String formedBy) {
        this.formedBy = formedBy;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getServiceAreaBranch() {
        return serviceAreaBranch;
    }

    public void setServiceAreaBranch(String serviceAreaBranch) {
        this.serviceAreaBranch = serviceAreaBranch;
    }
}
