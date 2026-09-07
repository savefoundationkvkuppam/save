package com.example.backend.controller;

import com.example.backend.entity.SbAccountApproval;
import com.example.backend.repository.SbAccountApprovalRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sb-account-approvals")
public class SbAccountApprovalController {

    private final SbAccountApprovalRepository repository;

    public SbAccountApprovalController(
            SbAccountApprovalRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<SbAccountApproval> getAll() {
        return repository.findAllByOrderByIdAsc();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SbAccountApproval> getById(
            @PathVariable Long id) {

        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public SbAccountApproval create(
            @RequestBody SbAccountApproval approval) {

        return repository.save(approval);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SbAccountApproval> update(
            @PathVariable Long id,
            @RequestBody SbAccountApproval updated) {

        return repository.findById(id)
                .map(existing -> {
                    existing.setAccountNumber(
                            updated.getAccountNumber());
                    existing.setBranchCode(
                            updated.getBranchCode());
                    existing.setBranchName(
                            updated.getBranchName());
                    existing.setBankName(
                            updated.getBankName());
                    existing.setApprovalStatus(
                            updated.getApprovalStatus());
                    existing.setApprovalDate(
                            updated.getApprovalDate());

                    return ResponseEntity.ok(
                            repository.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
