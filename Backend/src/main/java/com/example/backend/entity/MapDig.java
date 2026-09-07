package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "map_dig")
public class MapDig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String staffName;
    private String groupName;
    private String primaryReason;
    private String secondaryReason;
    private String tertiaryReason;
    private String quaternaryReason;
    private String quinaryReason;
    private String otherReason;
    private boolean selected = false;

    public MapDig() {
    }

    public Long getId() {
        return id;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getPrimaryReason() {
        return primaryReason;
    }

    public void setPrimaryReason(String primaryReason) {
        this.primaryReason = primaryReason;
    }

    public String getSecondaryReason() {
        return secondaryReason;
    }

    public void setSecondaryReason(String secondaryReason) {
        this.secondaryReason = secondaryReason;
    }

    public String getTertiaryReason() {
        return tertiaryReason;
    }

    public void setTertiaryReason(String tertiaryReason) {
        this.tertiaryReason = tertiaryReason;
    }

    public String getQuaternaryReason() {
        return quaternaryReason;
    }

    public void setQuaternaryReason(String quaternaryReason) {
        this.quaternaryReason = quaternaryReason;
    }

    public String getQuinaryReason() {
        return quinaryReason;
    }

    public void setQuinaryReason(String quinaryReason) {
        this.quinaryReason = quinaryReason;
    }

    public String getOtherReason() {
        return otherReason;
    }

    public void setOtherReason(String otherReason) {
        this.otherReason = otherReason;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
