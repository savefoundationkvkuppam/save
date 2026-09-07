package com.example.backend.repository;

import com.example.backend.entity.RequestEditTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestEditTransactionRepository extends JpaRepository<RequestEditTransaction, Long> {
    List<RequestEditTransaction> findByRequestedUpto(String requestedUpto);
    List<RequestEditTransaction> findByRequestedUptoAndApproved(String requestedUpto, boolean approved);
}

