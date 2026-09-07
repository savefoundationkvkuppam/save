package com.example.backend.repository;

import com.example.backend.entity.MeetingDateChangeRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeetingDateChangeRequestRepository
        extends JpaRepository<MeetingDateChangeRequest, Long> {

    List<MeetingDateChangeRequest> findByRequestedDateOrderByIdAsc(
            String requestedDate
    );
}
