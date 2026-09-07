package com.example.backend.repository;

import com.example.backend.entity.SbAccountApproval;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SbAccountApprovalRepository
        extends JpaRepository<SbAccountApproval, Long> {

    List<SbAccountApproval> findAllByOrderByIdAsc();
}
