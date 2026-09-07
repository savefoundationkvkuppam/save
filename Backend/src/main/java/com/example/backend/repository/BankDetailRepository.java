package com.example.backend.repository;

import com.example.backend.entity.BankDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankDetailRepository extends JpaRepository<BankDetail, Long> {
}
