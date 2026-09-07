package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "dig_meeting_status")
public class DigMeeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String meetingMonth;
    private String digGroupName;
    private String status;

    public DigMeeting() {
    }

    public Long getId() {
        return id;
    }

    public String getMeetingMonth() {
        return meetingMonth;
    }

    public void setMeetingMonth(String meetingMonth) {
        this.meetingMonth = meetingMonth;
    }

    public String getDigGroupName() {
        return digGroupName;
    }

    public void setDigGroupName(String digGroupName) {
        this.digGroupName = digGroupName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
