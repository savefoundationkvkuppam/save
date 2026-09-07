package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "loan_interest_rates")
public class LoanInterestRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vazhvathramCode;
    private String subLedger;
    private String annualRate;
    private String dateChange;

    public LoanInterestRate() {
    }

    public Long getId() {
        return id;
    }

    public String getVazhvathramCode() {
        return vazhvathramCode;
    }

    public void setVazhvathramCode(String vazhvathramCode) {
        this.vazhvathramCode = vazhvathramCode;
    }

    public String getSubLedger() {
        return subLedger;
    }

    public void setSubLedger(String subLedger) {
        this.subLedger = subLedger;
    }

    public String getAnnualRate() {
        return annualRate;
    }

    public void setAnnualRate(String annualRate) {
        this.annualRate = annualRate;
    }

    public String getDateChange() {
        return dateChange;
    }

    public void setDateChange(String dateChange) {
        this.dateChange = dateChange;
    }
}