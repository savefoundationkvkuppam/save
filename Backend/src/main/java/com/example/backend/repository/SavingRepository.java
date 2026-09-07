package com.example.backend.repository;

import com.example.backend.entity.Saving;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SavingRepository extends JpaRepository<Saving, Long> {
    List<Saving> findByMemberId(Long memberId);
}

