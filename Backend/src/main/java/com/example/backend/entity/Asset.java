package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "assets")
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long memberId;
    private String memberName;
    private String asset;
    private String quantity;
    private String purchaseYear;
    @Column(name = "value")
    private String value;
    private String insurance;

    public Asset() {}

    public Long getId() { return id; }
    public Long getMemberId() { return memberId; }
    public void setMemberId(Long memberId) { this.memberId = memberId; }
    public String getMemberName() { return memberName; }
    public void setMemberName(String memberName) { this.memberName = memberName; }
    public String getAsset() { return asset; }
    public void setAsset(String asset) { this.asset = asset; }
    public String getQuantity() { return quantity; }
    public void setQuantity(String quantity) { this.quantity = quantity; }
    public String getPurchaseYear() { return purchaseYear; }
    public void setPurchaseYear(String purchaseYear) { this.purchaseYear = purchaseYear; }
    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }
    public String getInsurance() { return insurance; }
    public void setInsurance(String insurance) { this.insurance = insurance; }
}

