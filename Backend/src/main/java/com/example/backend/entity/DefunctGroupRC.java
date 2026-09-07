package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "defunct_group_rc")
public class DefunctGroupRC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String groupName;

    private boolean defunct;

    private Integer noOfMonths;

    private String reason;

    public DefunctGroupRC() {
    }

    public Long getId() {
        return id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public boolean isDefunct() {
        return defunct;
    }

    public void setDefunct(boolean defunct) {
        this.defunct = defunct;
    }

    public Integer getNoOfMonths() {
        return noOfMonths;
    }

    public void setNoOfMonths(Integer noOfMonths) {
        this.noOfMonths = noOfMonths;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
