package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "external_debt")
public class ExternalDebt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long memberId;
    private String memberName;
    private String debtType;
    private String source;
    private String loanAmount;
    private String presentLoanOutstanding;
    private String yearOfBorrowing;
    private String interestRate;
    private String purposeOfLoan;
    private String repaymentFrequency;

    public ExternalDebt() {
    }

    public Long getId() {
        return id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getDebtType() {
        return debtType;
    }

    public void setDebtType(String debtType) {
        this.debtType = debtType;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getPresentLoanOutstanding() {
        return presentLoanOutstanding;
    }

    public void setPresentLoanOutstanding(String presentLoanOutstanding) {
        this.presentLoanOutstanding = presentLoanOutstanding;
    }

    public String getYearOfBorrowing() {
        return yearOfBorrowing;
    }

    public void setYearOfBorrowing(String yearOfBorrowing) {
        this.yearOfBorrowing = yearOfBorrowing;
    }

    public String getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }

    public String getPurposeOfLoan() {
        return purposeOfLoan;
    }

    public void setPurposeOfLoan(String purposeOfLoan) {
        this.purposeOfLoan = purposeOfLoan;
    }

    public String getRepaymentFrequency() {
        return repaymentFrequency;
    }

    public void setRepaymentFrequency(String repaymentFrequency) {
        this.repaymentFrequency = repaymentFrequency;
    }
}
