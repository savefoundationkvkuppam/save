package com.example.backend.repository;

import com.example.backend.entity.Livelihood;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivelihoodRepository extends JpaRepository<Livelihood, Long> {

    List<Livelihood> findByMemberId(Long memberId);

}