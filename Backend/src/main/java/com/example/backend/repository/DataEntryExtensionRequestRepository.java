package com.example.backend.repository;

import com.example.backend.entity.DataEntryExtensionRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DataEntryExtensionRequestRepository
        extends JpaRepository<DataEntryExtensionRequest, Long> {

    List<DataEntryExtensionRequest> findByRequestedUptoOrderByIdAsc(
            String requestedUpto
    );

    List<DataEntryExtensionRequest> findByRequestedUptoAndApprovedOrderByIdAsc(
            String requestedUpto,
            boolean approved
    );
}

