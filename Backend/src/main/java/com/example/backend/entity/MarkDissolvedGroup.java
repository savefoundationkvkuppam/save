package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "mark_dissolved_groups")
public class MarkDissolvedGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String groupName;
    private boolean markedDissolved;
    private String reason;

    public MarkDissolvedGroup() {}

    public Long getId() { return id; }
    public String getGroupName() { return groupName; }
    public void setGroupName(String groupName) { this.groupName = groupName; }
    public boolean isMarkedDissolved() { return markedDissolved; }
    public void setMarkedDissolved(boolean markedDissolved) { this.markedDissolved = markedDissolved; }
    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }
}
