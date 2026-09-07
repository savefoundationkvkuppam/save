package com.example.backend.repository;

import com.example.backend.entity.Livestock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivestockRepository extends JpaRepository<Livestock, Long> {
    List<Livestock> findByMemberId(Long memberId);
}
