package com.example.backend.repository;

import com.example.backend.entity.Legal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LegalRepository extends JpaRepository<Legal, Long> {
    List<Legal> findByMemberId(Long memberId);
}

