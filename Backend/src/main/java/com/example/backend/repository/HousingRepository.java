package com.example.backend.repository;

import com.example.backend.entity.Housing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HousingRepository extends JpaRepository<Housing, Long> {
    List<Housing> findByMemberId(Long memberId);
}
