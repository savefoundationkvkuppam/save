package com.example.backend.repository;

import com.example.backend.entity.ChangeMeetingDate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChangeMeetingDateRepository
        extends JpaRepository<ChangeMeetingDate, Long> {

    List<ChangeMeetingDate> findByChangeDate(String changeDate);

    List<ChangeMeetingDate> findByChangeDateAndApproved(
            String changeDate,
            boolean approved
    );
}
