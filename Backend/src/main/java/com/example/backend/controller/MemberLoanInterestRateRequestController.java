package com.example.backend.controller;

import com.example.backend.entity.MemberLoanInterestRateRequest;
import com.example.backend.repository.MemberLoanInterestRateRequestRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/member-loan-interest-rate")
@CrossOrigin(origins = "*")
public class MemberLoanInterestRateRequestController {

    private final MemberLoanInterestRateRequestRepository repository;

    public MemberLoanInterestRateRequestController(
            MemberLoanInterestRateRequestRepository repository
    ) {
        this.repository = repository;
    }

    @GetMapping
    public List<MemberLoanInterestRateRequest> getRequests(
            @RequestParam(required = false) String requestedUpto
    ) {
        if (requestedUpto == null || requestedUpto.trim().isEmpty()) {
            return repository.findAll();
        }

        return repository.findByRequestedUptoOrderByGroupNameAsc(
                requestedUpto.trim()
        );
    }

    @GetMapping("/approved")
    public List<MemberLoanInterestRateRequest> getApprovedRequests(
            @RequestParam(required = false) String requestedUpto
    ) {
        if (requestedUpto == null || requestedUpto.trim().isEmpty()) {
            return repository.findAll()
                    .stream()
                    .filter(MemberLoanInterestRateRequest::isApproved)
                    .toList();
        }

        return repository.findByRequestedUptoAndApprovedTrueOrderByGroupNameAsc(
                requestedUpto.trim()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberLoanInterestRateRequest> getById(
            @PathVariable Long id
    ) {
        Optional<MemberLoanInterestRateRequest> record = repository.findById(id);
        return record.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public MemberLoanInterestRateRequest create(
            @RequestBody MemberLoanInterestRateRequest request
    ) {
        return repository.save(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberLoanInterestRateRequest> update(
            @PathVariable Long id,
            @RequestBody MemberLoanInterestRateRequest updated
    ) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setRequestedUpto(updated.getRequestedUpto());
                    existing.setGroupName(updated.getGroupName());
                    existing.setOption(updated.getOption());
                    existing.setApproved(updated.isApproved());
                    return ResponseEntity.ok(repository.save(existing));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

