package com.example.backend.repository;

import com.example.backend.entity.MemberJournal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJournalRepository extends JpaRepository<MemberJournal, Long> {
}
