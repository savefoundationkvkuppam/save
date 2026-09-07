package com.example.backend.repository;

import com.example.backend.entity.ChangeInterestRateBank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChangeInterestRateBankRepository extends JpaRepository<ChangeInterestRateBank, Long> {
    List<ChangeInterestRateBank> findByChangeDate(String changeDate);
}
