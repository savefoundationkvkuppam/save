package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "meeting_date_change_requests")
public class MeetingDateChangeRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String requestedDate;
    private String groupName;
    private String option;

    public MeetingDateChangeRequest() {
    }

    public Long getId() {
        return id;
    }

    public String getRequestedDate() {
        return requestedDate;
    }

    public void setRequestedDate(String requestedDate) {
        this.requestedDate = requestedDate;
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
}

