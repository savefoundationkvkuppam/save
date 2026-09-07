package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "member_payments")
public class MemberPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String voucherNo;
    private String voucherDate;
    private String memberCode;
    private String memberName;
    private String voucherType;
    private String accountType;
    private String bankBranch;
    private String accountNo;
    private String chequeNo;
    private String savings;
    private String savingsIncentive;
    private String bulletSavings;
    private String socialSecurityType;
    private String socialSecurityAmount;
    private String specialSavingsType;
    private String specialSavingsAmount;
    private String specialSavingsMoreType;
    private String specialSavingsMoreAmount;
    private String specialSavingsIncentive;
    private String loanType;
    private String loanAmount;
    private String instalmentAmount;
    private String instalmentType;
    private String purpose;
    private String subPurpose;
    private String narration;
    private String total;

    public MemberPayment() {}

    public Long getId() { return id; }
    public String getVoucherNo() { return voucherNo; }
    public void setVoucherNo(String value) { this.voucherNo = value; }
    public String getVoucherDate() { return voucherDate; }
    public void setVoucherDate(String value) { this.voucherDate = value; }
    public String getMemberCode() { return memberCode; }
    public void setMemberCode(String value) { this.memberCode = value; }
    public String getMemberName() { return memberName; }
    public void setMemberName(String value) { this.memberName = value; }
    public String getVoucherType() { return voucherType; }
    public void setVoucherType(String value) { this.voucherType = value; }
    public String getAccountType() { return accountType; }
    public void setAccountType(String value) { this.accountType = value; }
    public String getBankBranch() { return bankBranch; }
    public void setBankBranch(String value) { this.bankBranch = value; }
    public String getAccountNo() { return accountNo; }
    public void setAccountNo(String value) { this.accountNo = value; }
    public String getChequeNo() { return chequeNo; }
    public void setChequeNo(String value) { this.chequeNo = value; }
    public String getSavings() { return savings; }
    public void setSavings(String value) { this.savings = value; }
    public String getSavingsIncentive() { return savingsIncentive; }
    public void setSavingsIncentive(String value) { this.savingsIncentive = value; }
    public String getBulletSavings() { return bulletSavings; }
    public void setBulletSavings(String value) { this.bulletSavings = value; }
    public String getSocialSecurityType() { return socialSecurityType; }
    public void setSocialSecurityType(String value) { this.socialSecurityType = value; }
    public String getSocialSecurityAmount() { return socialSecurityAmount; }
    public void setSocialSecurityAmount(String value) { this.socialSecurityAmount = value; }
    public String getSpecialSavingsType() { return specialSavingsType; }
    public void setSpecialSavingsType(String value) { this.specialSavingsType = value; }
    public String getSpecialSavingsAmount() { return specialSavingsAmount; }
    public void setSpecialSavingsAmount(String value) { this.specialSavingsAmount = value; }
    public String getSpecialSavingsMoreType() { return specialSavingsMoreType; }
    public void setSpecialSavingsMoreType(String value) { this.specialSavingsMoreType = value; }
    public String getSpecialSavingsMoreAmount() { return specialSavingsMoreAmount; }
    public void setSpecialSavingsMoreAmount(String value) { this.specialSavingsMoreAmount = value; }
    public String getSpecialSavingsIncentive() { return specialSavingsIncentive; }
    public void setSpecialSavingsIncentive(String value) { this.specialSavingsIncentive = value; }
    public String getLoanType() { return loanType; }
    public void setLoanType(String value) { this.loanType = value; }
    public String getLoanAmount() { return loanAmount; }
    public void setLoanAmount(String value) { this.loanAmount = value; }
    public String getInstalmentAmount() { return instalmentAmount; }
    public void setInstalmentAmount(String value) { this.instalmentAmount = value; }
    public String getInstalmentType() { return instalmentType; }
    public void setInstalmentType(String value) { this.instalmentType = value; }
    public String getPurpose() { return purpose; }
    public void setPurpose(String value) { this.purpose = value; }
    public String getSubPurpose() { return subPurpose; }
    public void setSubPurpose(String value) { this.subPurpose = value; }
    public String getNarration() { return narration; }
    public void setNarration(String value) { this.narration = value; }
    public String getTotal() { return total; }
    public void setTotal(String value) { this.total = value; }
}

