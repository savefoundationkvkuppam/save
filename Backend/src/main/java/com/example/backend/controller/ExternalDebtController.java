package com.example.backend.controller;

import com.example.backend.entity.ExternalDebt;
import com.example.backend.repository.ExternalDebtRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/external-debt")
public class ExternalDebtController {

    private final ExternalDebtRepository repository;

    public ExternalDebtController(ExternalDebtRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<ExternalDebt> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExternalDebt> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ExternalDebt create(@RequestBody ExternalDebt externalDebt) {
        return repository.save(externalDebt);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExternalDebt> update(
            @PathVariable Long id,
            @RequestBody ExternalDebt updated) {

        return repository.findById(id)
                .map(existing -> {
                    existing.setMemberId(updated.getMemberId());
                    existing.setMemberName(updated.getMemberName());
                    existing.setDebtType(updated.getDebtType());
                    existing.setSource(updated.getSource());
                    existing.setLoanAmount(updated.getLoanAmount());
                    existing.setPresentLoanOutstanding(
                            updated.getPresentLoanOutstanding()
                    );
                    existing.setYearOfBorrowing(updated.getYearOfBorrowing());
                    existing.setInterestRate(updated.getInterestRate());
                    existing.setPurposeOfLoan(updated.getPurposeOfLoan());
                    existing.setRepaymentFrequency(
                            updated.getRepaymentFrequency()
                    );

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

