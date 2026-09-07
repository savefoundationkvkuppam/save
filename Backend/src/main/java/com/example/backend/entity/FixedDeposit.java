package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "fixed_deposits")
public class FixedDeposit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bank;
    private String branch;
    private String receiptNumber;
    private String fdNumber;
    private String fdDate;
    private String fdAmount;
    private String interestRate;
    private String interestAmount;
    private String maturityDate;
    private String maturityAmount;
    private String closedDate;

    public FixedDeposit() {}

    public Long getId() { return id; }
    public String getBank() { return bank; }
    public void setBank(String v) { bank = v; }
    public String getBranch() { return branch; }
    public void setBranch(String v) { branch = v; }
    public String getReceiptNumber() { return receiptNumber; }
    public void setReceiptNumber(String v) { receiptNumber = v; }
    public String getFdNumber() { return fdNumber; }
    public void setFdNumber(String v) { fdNumber = v; }
    public String getFdDate() { return fdDate; }
    public void setFdDate(String v) { fdDate = v; }
    public String getFdAmount() { return fdAmount; }
    public void setFdAmount(String v) { fdAmount = v; }
    public String getInterestRate() { return interestRate; }
    public void setInterestRate(String v) { interestRate = v; }
    public String getInterestAmount() { return interestAmount; }
    public void setInterestAmount(String v) { interestAmount = v; }
    public String getMaturityDate() { return maturityDate; }
    public void setMaturityDate(String v) { maturityDate = v; }
    public String getMaturityAmount() { return maturityAmount; }
    public void setMaturityAmount(String v) { maturityAmount = v; }
    public String getClosedDate() { return closedDate; }
    public void setClosedDate(String v) { closedDate = v; }
}
