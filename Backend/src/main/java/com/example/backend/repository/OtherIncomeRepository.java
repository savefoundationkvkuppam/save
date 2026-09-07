package com.example.backend.repository;

import com.example.backend.entity.OtherIncome;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OtherIncomeRepository extends JpaRepository<OtherIncome, Long> {

    List<OtherIncome> findByMemberId(Long memberId);

}