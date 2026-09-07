package com.example.backend.repository;

import com.example.backend.entity.Vazhvathram;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VazhvathramRepository
        extends JpaRepository<Vazhvathram, Long> {
}