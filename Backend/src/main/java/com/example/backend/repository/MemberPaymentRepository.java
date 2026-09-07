package com.example.backend.repository;

import com.example.backend.entity.MemberPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberPaymentRepository extends JpaRepository<MemberPayment, Long> {
}
