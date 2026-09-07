package com.example.backend.repository;

import com.example.backend.entity.TransactionLock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransactionLockRepository extends JpaRepository<TransactionLock, Long> {
    Optional<TransactionLock> findTopByVazhvathramCodeAndMonthOrderByIdDesc(String vazhvathramCode, String month);
}
