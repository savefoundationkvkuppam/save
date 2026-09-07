package com.example.backend.repository;

import com.example.backend.entity.MutualLifeClaim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MutualLifeClaimRepository extends JpaRepository<MutualLifeClaim, Long> {
}

