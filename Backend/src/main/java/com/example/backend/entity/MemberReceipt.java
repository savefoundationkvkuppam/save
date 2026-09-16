
package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "member_receipts")
public class MemberReceipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String receiptNo;
    private String receiptDate;
    private String cash;
    private String accountType;
    private String branch;
    private String accountNo;
    private String chequeNo;
    private String memberCode;
    private String memberName;
    private String regularSavings;
    private String bulletSavings;
    private String specialSavings;
    private String specialSavingsAmount;
    private String specialSavingsMoreType;
    private String specialSavingsMoreAmount;
    private String livelihoodLoanSupport1;
    private String serviceCost1;
    private String livelihoodLoanSupport2;
    private String serviceCost2;
    private String housingLoan;
    private String housingServiceCost;
    private String total;

    private String donation;
    private String jothiFund;
    private String riskFund;
    private String drrFund;
    private String subsEntFee;
    private String specifiedProgFund;

    private String memberLife;
    private String spouseLife;
    private String livestock;
    private String health;
    private String pension;
    private String endowment;
    private String crop;

    private String tataAiaMember;
    private String tataAiaSpouse;

    private String lifeMember;
    private String lifeSpouse;
    private String mutualHealth;
    private String mutualLivestock;
    private String mutualCrop;
    private String funeral;
    private String admin;
    private String nalam;

    @Column(columnDefinition = "TEXT")
    private String additionalDetails;

    public MemberReceipt() {}

    public Long getId() { return id; }
    public String getReceiptNo() { return receiptNo; }
    public void setReceiptNo(String receiptNo) { this.receiptNo = receiptNo; }
    public String getReceiptDate() { return receiptDate; }
    public void setReceiptDate(String receiptDate) { this.receiptDate = receiptDate; }
    public String getCash() { return cash; }
    public void setCash(String cash) { this.cash = cash; }
    public String getAccountType() { return accountType; }
    public void setAccountType(String accountType) { this.accountType = accountType; }
    public String getBranch() { return branch; }
    public void setBranch(String branch) { this.branch = branch; }
    public String getAccountNo() { return accountNo; }
    public void setAccountNo(String accountNo) { this.accountNo = accountNo; }
    public String getChequeNo() { return chequeNo; }
    public void setChequeNo(String chequeNo) { this.chequeNo = chequeNo; }
    public String getMemberCode() { return memberCode; }
    public void setMemberCode(String memberCode) { this.memberCode = memberCode; }
    public String getMemberName() { return memberName; }
    public void setMemberName(String memberName) { this.memberName = memberName; }
    public String getRegularSavings() { return regularSavings; }
    public void setRegularSavings(String regularSavings) { this.regularSavings = regularSavings; }
    public String getBulletSavings() { return bulletSavings; }
    public void setBulletSavings(String bulletSavings) { this.bulletSavings = bulletSavings; }
    public String getSpecialSavings() { return specialSavings; }
    public void setSpecialSavings(String specialSavings) { this.specialSavings = specialSavings; }
    public String getSpecialSavingsAmount() { return specialSavingsAmount; }
    public void setSpecialSavingsAmount(String specialSavingsAmount) { this.specialSavingsAmount = specialSavingsAmount; }
    public String getSpecialSavingsMoreType() { return specialSavingsMoreType; }
    public void setSpecialSavingsMoreType(String specialSavingsMoreType) { this.specialSavingsMoreType = specialSavingsMoreType; }
    public String getSpecialSavingsMoreAmount() { return specialSavingsMoreAmount; }
    public void setSpecialSavingsMoreAmount(String specialSavingsMoreAmount) { this.specialSavingsMoreAmount = specialSavingsMoreAmount; }
    public String getLivelihoodLoanSupport1() { return livelihoodLoanSupport1; }
    public void setLivelihoodLoanSupport1(String livelihoodLoanSupport1) { this.livelihoodLoanSupport1 = livelihoodLoanSupport1; }
    public String getServiceCost1() { return serviceCost1; }
    public void setServiceCost1(String serviceCost1) { this.serviceCost1 = serviceCost1; }
    public String getLivelihoodLoanSupport2() { return livelihoodLoanSupport2; }
    public void setLivelihoodLoanSupport2(String livelihoodLoanSupport2) { this.livelihoodLoanSupport2 = livelihoodLoanSupport2; }
    public String getServiceCost2() { return serviceCost2; }
    public void setServiceCost2(String serviceCost2) { this.serviceCost2 = serviceCost2; }
    public String getHousingLoan() { return housingLoan; }
    public void setHousingLoan(String housingLoan) { this.housingLoan = housingLoan; }
    public String getHousingServiceCost() { return housingServiceCost; }
    public void setHousingServiceCost(String housingServiceCost) { this.housingServiceCost = housingServiceCost; }
    public String getTotal() { return total; }
    public void setTotal(String total) { this.total = total; }
    public String getDonation() { return donation; }
public void setDonation(String donation) { this.donation = donation; }

public String getJothiFund() { return jothiFund; }
public void setJothiFund(String jothiFund) { this.jothiFund = jothiFund; }

public String getRiskFund() { return riskFund; }
public void setRiskFund(String riskFund) { this.riskFund = riskFund; }

public String getDrrFund() { return drrFund; }
public void setDrrFund(String drrFund) { this.drrFund = drrFund; }

public String getSubsEntFee() { return subsEntFee; }
public void setSubsEntFee(String subsEntFee) { this.subsEntFee = subsEntFee; }

public String getSpecifiedProgFund() { return specifiedProgFund; }
public void setSpecifiedProgFund(String specifiedProgFund) { this.specifiedProgFund = specifiedProgFund; }

public String getMemberLife() { return memberLife; }
public void setMemberLife(String memberLife) { this.memberLife = memberLife; }

public String getSpouseLife() { return spouseLife; }
public void setSpouseLife(String spouseLife) { this.spouseLife = spouseLife; }

public String getLivestock() { return livestock; }
public void setLivestock(String livestock) { this.livestock = livestock; }

public String getHealth() { return health; }
public void setHealth(String health) { this.health = health; }

public String getPension() { return pension; }
public void setPension(String pension) { this.pension = pension; }

public String getEndowment() { return endowment; }
public void setEndowment(String endowment) { this.endowment = endowment; }

public String getCrop() { return crop; }
public void setCrop(String crop) { this.crop = crop; }

public String getTataAiaMember() { return tataAiaMember; }
public void setTataAiaMember(String tataAiaMember) { this.tataAiaMember = tataAiaMember; }

public String getTataAiaSpouse() { return tataAiaSpouse; }
public void setTataAiaSpouse(String tataAiaSpouse) { this.tataAiaSpouse = tataAiaSpouse; }

public String getLifeMember() { return lifeMember; }
public void setLifeMember(String lifeMember) { this.lifeMember = lifeMember; }

public String getLifeSpouse() { return lifeSpouse; }
public void setLifeSpouse(String lifeSpouse) { this.lifeSpouse = lifeSpouse; }

public String getMutualHealth() { return mutualHealth; }
public void setMutualHealth(String mutualHealth) { this.mutualHealth = mutualHealth; }

public String getMutualLivestock() { return mutualLivestock; }
public void setMutualLivestock(String mutualLivestock) { this.mutualLivestock = mutualLivestock; }

public String getMutualCrop() { return mutualCrop; }
public void setMutualCrop(String mutualCrop) { this.mutualCrop = mutualCrop; }

public String getFuneral() { return funeral; }
public void setFuneral(String funeral) { this.funeral = funeral; }

public String getAdmin() { return admin; }
public void setAdmin(String admin) { this.admin = admin; }

public String getNalam() { return nalam; }
public void setNalam(String nalam) { this.nalam = nalam; }
    public String getAdditionalDetails() { return additionalDetails; }
    public void setAdditionalDetails(String additionalDetails) { this.additionalDetails = additionalDetails; }
}
