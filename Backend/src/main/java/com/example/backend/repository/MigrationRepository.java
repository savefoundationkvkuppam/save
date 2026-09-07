package com.example.backend.repository;

import com.example.backend.entity.Migration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MigrationRepository extends JpaRepository<Migration, Long> {

    List<Migration> findByMemberId(Long memberId);
}
