package com.example.backend.repository;

import com.example.backend.entity.AutoJournalLock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutoJournalLockRepository extends JpaRepository<AutoJournalLock, Long> {
    Optional<AutoJournalLock> findByVazhvathramCodeAndMonth(String vazhvathramCode, String month);
}
