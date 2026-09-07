package com.example.backend.repository;

import com.example.backend.entity.MemberLoanInterestRateRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberLoanInterestRateRequestRepository
        extends JpaRepository<MemberLoanInterestRateRequest, Long> {

    List<MemberLoanInterestRateRequest> findByRequestedUptoOrderByGroupNameAsc(
            String requestedUpto
    );

    List<MemberLoanInterestRateRequest> findByRequestedUptoAndApprovedTrueOrderByGroupNameAsc(
            String requestedUpto
    );
}
