package com.example.backend.repository;

import com.example.backend.entity.FixedDeposit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FixedDepositRepository extends JpaRepository<FixedDeposit, Long> {
}
