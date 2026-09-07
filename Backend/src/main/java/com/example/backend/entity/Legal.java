package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "legals")
public class Legal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long memberId;
    private String vazhvatharamCode;
    private String memberName;
    private String particulars;
    private String disputeDetails;

    public Legal() {
    }

    public Long getId() { return id; }

    public Long getMemberId() { return memberId; }
    public void setMemberId(Long memberId) { this.memberId = memberId; }

    public String getVazhvatharamCode() { return vazhvatharamCode; }
    public void setVazhvatharamCode(String vazhvatharamCode) { this.vazhvatharamCode = vazhvatharamCode; }

    public String getMemberName() { return memberName; }
    public void setMemberName(String memberName) { this.memberName = memberName; }

    public String getParticulars() { return particulars; }
    public void setParticulars(String particulars) { this.particulars = particulars; }

    public String getDisputeDetails() { return disputeDetails; }
    public void setDisputeDetails(String disputeDetails) { this.disputeDetails = disputeDetails; }
}

