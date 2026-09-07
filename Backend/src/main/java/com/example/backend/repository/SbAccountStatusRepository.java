package com.example.backend.repository;

import com.example.backend.entity.SbAccountStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SbAccountStatusRepository
        extends JpaRepository<SbAccountStatus, Long> {

    List<SbAccountStatus> findAllByOrderByIdAsc();
}
