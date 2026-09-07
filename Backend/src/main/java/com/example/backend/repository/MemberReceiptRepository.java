package com.example.backend.repository;

import com.example.backend.entity.MemberReceipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberReceiptRepository extends JpaRepository<MemberReceipt, Long> {
}
