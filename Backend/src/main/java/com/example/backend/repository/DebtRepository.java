package com.example.backend.repository;

import com.example.backend.entity.Debt;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DebtRepository extends JpaRepository<Debt, Long> {
    List<Debt> findByMemberId(Long memberId);
}

