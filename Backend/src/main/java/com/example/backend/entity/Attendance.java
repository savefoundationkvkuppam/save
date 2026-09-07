package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "attendances")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String meetingDate;
    private String rvColDate;
    private String reason;
    private String otherReason;
    private boolean notConducted;
    private boolean specialMeeting;

    @Column(columnDefinition = "TEXT")
    private String attendedMembers;

    public Attendance() {}

    public Long getId() { return id; }
    public String getMeetingDate() { return meetingDate; }
    public void setMeetingDate(String meetingDate) { this.meetingDate = meetingDate; }
    public String getRvColDate() { return rvColDate; }
    public void setRvColDate(String rvColDate) { this.rvColDate = rvColDate; }
    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }
    public String getOtherReason() { return otherReason; }
    public void setOtherReason(String otherReason) { this.otherReason = otherReason; }
    public boolean isNotConducted() { return notConducted; }
    public void setNotConducted(boolean notConducted) { this.notConducted = notConducted; }
    public boolean isSpecialMeeting() { return specialMeeting; }
    public void setSpecialMeeting(boolean specialMeeting) { this.specialMeeting = specialMeeting; }
    public String getAttendedMembers() { return attendedMembers; }
    public void setAttendedMembers(String attendedMembers) { this.attendedMembers = attendedMembers; }
}

