package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "mutual_life_enrollments")
public class MutualLifeEnrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String idNo;

    private String memberName;

    private String insurerName;

    private String relationshipWithMember;

    private String gender;

    private String nomineeName;

    private String nomineeRelationWithInsurer;

    private String ageProof;

    private String cardNo;

    private String receiptNumber;

    private String receiptDate;

    private String receiptAmount;

    private String companyName;

    private String insuranceScheme;

    public MutualLifeEnrollment() {
    }

    public Long getId() { return id; }

    public String getIdNo() { return idNo; }
    public void setIdNo(String idNo) { this.idNo = idNo; }

    public String getMemberName() { return memberName; }
    public void setMemberName(String memberName) { this.memberName = memberName; }

    public String getInsurerName() { return insurerName; }
    public void setInsurerName(String insurerName) { this.insurerName = insurerName; }

    public String getRelationshipWithMember() { return relationshipWithMember; }
    public void setRelationshipWithMember(String relationshipWithMember) { this.relationshipWithMember = relationshipWithMember; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getNomineeName() { return nomineeName; }
    public void setNomineeName(String nomineeName) { this.nomineeName = nomineeName; }

    public String getNomineeRelationWithInsurer() { return nomineeRelationWithInsurer; }
    public void setNomineeRelationWithInsurer(String nomineeRelationWithInsurer) { this.nomineeRelationWithInsurer = nomineeRelationWithInsurer; }

    public String getAgeProof() { return ageProof; }
    public void setAgeProof(String ageProof) { this.ageProof = ageProof; }

    public String getCardNo() { return cardNo; }
    public void setCardNo(String cardNo) { this.cardNo = cardNo; }

    public String getReceiptNumber() { return receiptNumber; }
    public void setReceiptNumber(String receiptNumber) { this.receiptNumber = receiptNumber; }

    public String getReceiptDate() { return receiptDate; }
    public void setReceiptDate(String receiptDate) { this.receiptDate = receiptDate; }

    public String getReceiptAmount() { return receiptAmount; }
    public void setReceiptAmount(String receiptAmount) { this.receiptAmount = receiptAmount; }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public String getInsuranceScheme() { return insuranceScheme; }
    public void setInsuranceScheme(String insuranceScheme) { this.insuranceScheme = insuranceScheme; }

}

