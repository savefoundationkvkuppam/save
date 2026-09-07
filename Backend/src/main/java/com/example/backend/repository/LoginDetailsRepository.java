package com.example.backend.repository;

import com.example.backend.entity.LoginDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LoginDetailsRepository extends JpaRepository<LoginDetails, Long> {

    Optional<LoginDetails> findByUserIdAndPassword(String userId, String password);
}