package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "bank_details")
public class BankDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bankCode;
    private String bankName;
    private String standardBankName;

    public BankDetail() {}

    public Long getId() {
        return id;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getStandardBankName() {
        return standardBankName;
    }

    public void setStandardBankName(String standardBankName) {
        this.standardBankName = standardBankName;
    }
}

