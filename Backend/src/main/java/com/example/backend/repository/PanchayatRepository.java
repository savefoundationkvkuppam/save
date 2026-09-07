package com.example.backend.repository;

import com.example.backend.entity.Panchayat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PanchayatRepository
        extends JpaRepository<Panchayat, Long> {
}