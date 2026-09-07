
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
    public String getAdditionalDetails() { return additionalDetails; }
    public void setAdditionalDetails(String additionalDetails) { this.additionalDetails = additionalDetails; }
}
