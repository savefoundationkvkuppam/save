package com.example.backend.repository;

import com.example.backend.entity.ExternalDebt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExternalDebtRepository extends JpaRepository<ExternalDebt, Long> {
}

