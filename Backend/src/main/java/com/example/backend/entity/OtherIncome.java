package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "other_incomes")
public class OtherIncome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long memberId;

    private String memberName;

    private String houseRent;

    private String emptyLandRent;

    public OtherIncome() {
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

    public String getHouseRent() {
        return houseRent;
    }

    public void setHouseRent(String houseRent) {
        this.houseRent = houseRent;
    }

    public String getEmptyLandRent() {
        return emptyLandRent;
    }

    public void setEmptyLandRent(String emptyLandRent) {
        this.emptyLandRent = emptyLandRent;
    }
}
