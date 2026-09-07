package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "mutual_life_claims")
public class MutualLifeClaim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String memberName;

    private String claimNo;

    private String insurerName;

    private String claimReceivedDate;

    private String benefitType;

    private String benefitAmount;

    private String causeOfDeath;

    private String bankName;

    private String dateOfDeath;

    private String branchName;

    private String sbAccountNo;

    private String placeOfEvent;

    private String nomineeName;

    private String utilization;

    public MutualLifeClaim() {
    }

    public Long getId() { return id; }

    public String getMemberName() { return memberName; }
    public void setMemberName(String memberName) { this.memberName = memberName; }

    public String getClaimNo() { return claimNo; }
    public void setClaimNo(String claimNo) { this.claimNo = claimNo; }

    public String getInsurerName() { return insurerName; }
    public void setInsurerName(String insurerName) { this.insurerName = insurerName; }

    public String getClaimReceivedDate() { return claimReceivedDate; }
    public void setClaimReceivedDate(String claimReceivedDate) { this.claimReceivedDate = claimReceivedDate; }

    public String getBenefitType() { return benefitType; }
    public void setBenefitType(String benefitType) { this.benefitType = benefitType; }

    public String getBenefitAmount() { return benefitAmount; }
    public void setBenefitAmount(String benefitAmount) { this.benefitAmount = benefitAmount; }

    public String getCauseOfDeath() { return causeOfDeath; }
    public void setCauseOfDeath(String causeOfDeath) { this.causeOfDeath = causeOfDeath; }

    public String getBankName() { return bankName; }
    public void setBankName(String bankName) { this.bankName = bankName; }

    public String getDateOfDeath() { return dateOfDeath; }
    public void setDateOfDeath(String dateOfDeath) { this.dateOfDeath = dateOfDeath; }

    public String getBranchName() { return branchName; }
    public void setBranchName(String branchName) { this.branchName = branchName; }

    public String getSbAccountNo() { return sbAccountNo; }
    public void setSbAccountNo(String sbAccountNo) { this.sbAccountNo = sbAccountNo; }

    public String getPlaceOfEvent() { return placeOfEvent; }
    public void setPlaceOfEvent(String placeOfEvent) { this.placeOfEvent = placeOfEvent; }

    public String getNomineeName() { return nomineeName; }
    public void setNomineeName(String nomineeName) { this.nomineeName = nomineeName; }

    public String getUtilization() { return utilization; }
    public void setUtilization(String utilization) { this.utilization = utilization; }

}
