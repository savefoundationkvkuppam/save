package com.example.backend.repository;

import com.example.backend.entity.InsuranceProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceProductRepository
        extends JpaRepository<InsuranceProduct, Long> {
}