package com.example.backend.repository;

import com.example.backend.entity.Entitlement;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EntitlementRepository extends JpaRepository<Entitlement, Long> {
    List<Entitlement> findByMemberId(Long memberId);
}

