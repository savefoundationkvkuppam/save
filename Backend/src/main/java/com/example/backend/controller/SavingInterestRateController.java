package com.example.backend.controller;

import com.example.backend.entity.SavingInterestRate;
import com.example.backend.repository.SavingInterestRateRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/saving-interest-rates")
@CrossOrigin(origins = "http://localhost:5173")
public class SavingInterestRateController {

    private final SavingInterestRateRepository repository;

    public SavingInterestRateController(SavingInterestRateRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<SavingInterestRate> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SavingInterestRate> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public SavingInterestRate create(@RequestBody SavingInterestRate rate) {
        return repository.save(rate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SavingInterestRate> update(
            @PathVariable Long id,
            @RequestBody SavingInterestRate updated) {

        return repository.findById(id)
                .map(existing -> {
                    existing.setVazhvathramCode(updated.getVazhvathramCode());
                    existing.setSubLedger(updated.getSubLedger());
                    existing.setAnnualRate(updated.getAnnualRate());
                    existing.setDateChange(updated.getDateChange());
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
