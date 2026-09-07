package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "change_interest_rates_bank")
public class ChangeInterestRateBank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String changeDate;
    private String recNoLoanType;

    @Column(columnDefinition = "TEXT")
    private String bankBranchLoan;

    private String principalOs;
    private String interestRate;

    public ChangeInterestRateBank() {
    }

    public Long getId() {
        return id;
    }

    public String getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(String changeDate) {
        this.changeDate = changeDate;
    }

    public String getRecNoLoanType() {
        return recNoLoanType;
    }

    public void setRecNoLoanType(String recNoLoanType) {
        this.recNoLoanType = recNoLoanType;
    }

    public String getBankBranchLoan() {
        return bankBranchLoan;
    }

    public void setBankBranchLoan(String bankBranchLoan) {
        this.bankBranchLoan = bankBranchLoan;
    }

    public String getPrincipalOs() {
        return principalOs;
    }

    public void setPrincipalOs(String principalOs) {
        this.principalOs = principalOs;
    }

    public String getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }
}

