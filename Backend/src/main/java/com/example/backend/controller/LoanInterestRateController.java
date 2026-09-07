package com.example.backend.controller;

import com.example.backend.entity.LoanInterestRate;
import com.example.backend.repository.LoanInterestRateRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loan-interest-rates")
@CrossOrigin(origins = "http://localhost:5173")
public class LoanInterestRateController {

    private final LoanInterestRateRepository repository;

    public LoanInterestRateController(
            LoanInterestRateRepository repository) {
        this.repository = repository;
    }

    // GET ALL
    @GetMapping
    public List<LoanInterestRate> getAll() {
        return repository.findAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<LoanInterestRate> getById(
            @PathVariable Long id) {

        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ADD
    @PostMapping
    public LoanInterestRate create(
            @RequestBody LoanInterestRate loanInterestRate) {

        return repository.save(loanInterestRate);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<LoanInterestRate> update(
            @PathVariable Long id,
            @RequestBody LoanInterestRate updated) {

        return repository.findById(id)
                .map(existing -> {

                    existing.setVazhvathramCode(
                            updated.getVazhvathramCode()
                    );

                    existing.setSubLedger(
                            updated.getSubLedger()
                    );

                    existing.setAnnualRate(
                            updated.getAnnualRate()
                    );

                    existing.setDateChange(
                            updated.getDateChange()
                    );

                    return ResponseEntity.ok(
                            repository.save(existing)
                    );
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE
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