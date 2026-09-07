package com.example.backend.controller;

import com.example.backend.entity.Saving;
import com.example.backend.repository.SavingRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/savings")
public class SavingController {

    private final SavingRepository repository;

    public SavingController(SavingRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Saving> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Saving> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/member/{memberId}")
    public List<Saving> getByMemberId(@PathVariable Long memberId) {
        return repository.findByMemberId(memberId);
    }

    @PostMapping
    public Saving create(@RequestBody Saving saving) {
        return repository.save(saving);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Saving> update(@PathVariable Long id, @RequestBody Saving updated) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setMemberId(updated.getMemberId());
                    existing.setMemberName(updated.getMemberName());
                    existing.setSource(updated.getSource());
                    existing.setTotalCumulativeAmount(updated.getTotalCumulativeAmount());
                    existing.setSavingsFrequency(updated.getSavingsFrequency());
                    existing.setInterestRate(updated.getInterestRate());
                    existing.setMonthlySavings(updated.getMonthlySavings());
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

