package com.example.backend.controller;

import com.example.backend.entity.SbAccountStatus;
import com.example.backend.repository.SbAccountStatusRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sb-account-statuses")
public class SbAccountStatusController {

    private final SbAccountStatusRepository repository;

    public SbAccountStatusController(SbAccountStatusRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<SbAccountStatus> getAll() {
        return repository.findAllByOrderByIdAsc();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SbAccountStatus> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public SbAccountStatus create(@RequestBody SbAccountStatus accountStatus) {
        return repository.save(accountStatus);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SbAccountStatus> update(
            @PathVariable Long id,
            @RequestBody SbAccountStatus updated) {

        return repository.findById(id)
                .map(existing -> {
                    existing.setAccountNumber(updated.getAccountNumber());
                    existing.setBranchCode(updated.getBranchCode());
                    existing.setBranchName(updated.getBranchName());
                    existing.setBankName(updated.getBankName());
                    existing.setStatus(updated.getStatus());
                    existing.setStatusDate(updated.getStatusDate());

                    return ResponseEntity.ok(repository.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
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
