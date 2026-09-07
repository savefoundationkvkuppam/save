package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "livestocks")
public class Livestock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long memberId;
    private String memberName;
    private String livestock;
    private String quantity;
    private String presentValue;
    private String annualIncome;
    private String insurance;

    public Livestock() {
    }

    public Long getId() { return id; }
    public Long getMemberId() { return memberId; }
    public void setMemberId(Long memberId) { this.memberId = memberId; }
    public String getMemberName() { return memberName; }
    public void setMemberName(String memberName) { this.memberName = memberName; }
    public String getLivestock() { return livestock; }
    public void setLivestock(String livestock) { this.livestock = livestock; }
    public String getQuantity() { return quantity; }
    public void setQuantity(String quantity) { this.quantity = quantity; }
    public String getPresentValue() { return presentValue; }
    public void setPresentValue(String presentValue) { this.presentValue = presentValue; }
    public String getAnnualIncome() { return annualIncome; }
    public void setAnnualIncome(String annualIncome) { this.annualIncome = annualIncome; }
    public String getInsurance() { return insurance; }
    public void setInsurance(String insurance) { this.insurance = insurance; }
}

