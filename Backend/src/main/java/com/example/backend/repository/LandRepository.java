package com.example.backend.repository;

import com.example.backend.entity.Land;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LandRepository extends JpaRepository<Land, Long> {
    List<Land> findByMemberId(Long memberId);
}

