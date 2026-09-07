package com.example.backend.repository;

import com.example.backend.entity.TempJournalLock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TempJournalLockRepository extends JpaRepository<TempJournalLock, Long> {
    Optional<TempJournalLock> findTopByVazhvathramCodeAndMonthOrderByIdDesc(String vazhvathramCode, String month);
}
