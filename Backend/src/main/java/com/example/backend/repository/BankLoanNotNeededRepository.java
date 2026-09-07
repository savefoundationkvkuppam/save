package com.example.backend.repository;

import com.example.backend.entity.BankLoanNotNeeded;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankLoanNotNeededRepository
        extends JpaRepository<BankLoanNotNeeded, Long> {
}

