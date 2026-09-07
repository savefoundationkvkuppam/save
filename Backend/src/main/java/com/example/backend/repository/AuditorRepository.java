package com.example.backend.repository;

import com.example.backend.entity.Auditor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditorRepository extends JpaRepository<Auditor, Long> {
}