package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "savings")
public class Saving {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long memberId;
    private String memberName;
    private String source;
    private String totalCumulativeAmount;
    private String savingsFrequency;
    private String interestRate;
    private String monthlySavings;

    public Saving() {
    }

    public Long getId() { return id; }
    public Long getMemberId() { return memberId; }
    public void setMemberId(Long memberId) { this.memberId = memberId; }
    public String getMemberName() { return memberName; }
    public void setMemberName(String memberName) { this.memberName = memberName; }
    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }
    public String getTotalCumulativeAmount() { return totalCumulativeAmount; }
    public void setTotalCumulativeAmount(String totalCumulativeAmount) { this.totalCumulativeAmount = totalCumulativeAmount; }
    public String getSavingsFrequency() { return savingsFrequency; }
    public void setSavingsFrequency(String savingsFrequency) { this.savingsFrequency = savingsFrequency; }
    public String getInterestRate() { return interestRate; }
    public void setInterestRate(String interestRate) { this.interestRate = interestRate; }
    public String getMonthlySavings() { return monthlySavings; }
    public void setMonthlySavings(String monthlySavings) { this.monthlySavings = monthlySavings; }
}

