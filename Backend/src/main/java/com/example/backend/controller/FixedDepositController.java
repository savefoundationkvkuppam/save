package com.example.backend.controller;

import com.example.backend.entity.FixedDeposit;
import com.example.backend.repository.FixedDepositRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fixed-deposits")
@CrossOrigin(origins = "http://localhost:5173")
public class FixedDepositController {
    private final FixedDepositRepository repository;

    public FixedDepositController(FixedDepositRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<FixedDeposit> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FixedDeposit> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public FixedDeposit create(@RequestBody FixedDeposit fixedDeposit) {
        return repository.save(fixedDeposit);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FixedDeposit> update(
            @PathVariable Long id,
            @RequestBody FixedDeposit updated) {
        return repository.findById(id).map(existing -> {
            existing.setBank(updated.getBank());
            existing.setBranch(updated.getBranch());
            existing.setReceiptNumber(updated.getReceiptNumber());
            existing.setFdNumber(updated.getFdNumber());
            existing.setFdDate(updated.getFdDate());
            existing.setFdAmount(updated.getFdAmount());
            existing.setInterestRate(updated.getInterestRate());
            existing.setInterestAmount(updated.getInterestAmount());
            existing.setMaturityDate(updated.getMaturityDate());
            existing.setMaturityAmount(updated.getMaturityAmount());
            existing.setClosedDate(updated.getClosedDate());
            return ResponseEntity.ok(repository.save(existing));
        }).orElse(ResponseEntity.notFound().build());
    }
}
