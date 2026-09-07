package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "request_edit_transactions")
public class RequestEditTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String requestedUpto;
    private String groupName;

    @Column(columnDefinition = "TEXT")
    private String option;

    private boolean approved = false;

    public RequestEditTransaction() {}

    public Long getId() { return id; }
    public String getRequestedUpto() { return requestedUpto; }
    public void setRequestedUpto(String requestedUpto) { this.requestedUpto = requestedUpto; }
    public String getGroupName() { return groupName; }
    public void setGroupName(String groupName) { this.groupName = groupName; }
    public String getOption() { return option; }
    public void setOption(String option) { this.option = option; }
    public boolean isApproved() { return approved; }
    public void setApproved(boolean approved) { this.approved = approved; }
}

