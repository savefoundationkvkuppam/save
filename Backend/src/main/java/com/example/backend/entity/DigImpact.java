package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "dig_impact")
public class DigImpact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long mapDigId;
    private String groupName;
    private String purpose;
    private String impactStatus;

    public DigImpact() {}

    public Long getId() { return id; }
    public Long getMapDigId() { return mapDigId; }
    public void setMapDigId(Long mapDigId) { this.mapDigId = mapDigId; }
    public String getGroupName() { return groupName; }
    public void setGroupName(String groupName) { this.groupName = groupName; }
    public String getPurpose() { return purpose; }
    public void setPurpose(String purpose) { this.purpose = purpose; }
    public String getImpactStatus() { return impactStatus; }
    public void setImpactStatus(String impactStatus) { this.impactStatus = impactStatus; }
}
