package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "dig_rc_approval")
public class DigRcApproval {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long mapDigId;
    private String groupName;
    private boolean approved;

    public DigRcApproval() {
    }

    public Long getId() {
        return id;
    }

    public Long getMapDigId() {
        return mapDigId;
    }

    public void setMapDigId(Long mapDigId) {
        this.mapDigId = mapDigId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}
