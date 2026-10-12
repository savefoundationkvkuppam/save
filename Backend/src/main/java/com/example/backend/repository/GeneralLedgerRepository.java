package com.example.backend.repository;

import com.example.backend.entity.GeneralLedger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneralLedgerRepository
        extends JpaRepository<GeneralLedger, Long> {
   boolean existsByGlCode(String glCode);
}
