package com.example.backend.repository;

import com.example.backend.entity.LoanInterestRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanInterestRateRepository
        extends JpaRepository<LoanInterestRate, Long> {
}

