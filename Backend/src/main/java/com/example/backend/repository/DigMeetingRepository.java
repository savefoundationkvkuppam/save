package com.example.backend.repository;

import com.example.backend.entity.DigMeeting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DigMeetingRepository extends JpaRepository<DigMeeting, Long> {
    List<DigMeeting> findByMeetingMonth(String meetingMonth);
}
