package com.example.backend.controller;

import com.example.backend.entity.ChangeInterestRateBank;
import com.example.backend.repository.ChangeInterestRateBankRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/change-interest-rates-bank")
@CrossOrigin(origins = "http://localhost:5173")
public class ChangeInterestRateBankController {

    private final ChangeInterestRateBankRepository repository;

    public ChangeInterestRateBankController(ChangeInterestRateBankRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<ChangeInterestRateBank> getByDate(
            @RequestParam(required = false) String date) {
        if (date == null || date.trim().isEmpty()) {
            return repository.findAll();
        }
        return repository.findByChangeDate(date.trim());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChangeInterestRateBank> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ChangeInterestRateBank create(@RequestBody ChangeInterestRateBank record) {
        return repository.save(record);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChangeInterestRateBank> update(
            @PathVariable Long id,
            @RequestBody ChangeInterestRateBank updated) {

        return repository.findById(id)
                .map(existing -> {
                    existing.setChangeDate(updated.getChangeDate());
                    existing.setRecNoLoanType(updated.getRecNoLoanType());
                    existing.setBankBranchLoan(updated.getBankBranchLoan());
                    existing.setPrincipalOs(updated.getPrincipalOs());
                    existing.setInterestRate(updated.getInterestRate());
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
