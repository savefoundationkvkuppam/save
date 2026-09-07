package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "data_entry_extension_requests")
public class DataEntryExtensionRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String requestedUpto;
    private String groupName;
    private String option;
    private boolean approved;

    public DataEntryExtensionRequest() {
    }

    public Long getId() {
        return id;
    }

    public String getRequestedUpto() {
        return requestedUpto;
    }

    public void setRequestedUpto(String requestedUpto) {
        this.requestedUpto = requestedUpto;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}

