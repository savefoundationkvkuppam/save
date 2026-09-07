package com.example.backend.repository;

import com.example.backend.entity.Health;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HealthRepository extends JpaRepository<Health, Long> {
    List<Health> findByMemberId(Long memberId);
}

