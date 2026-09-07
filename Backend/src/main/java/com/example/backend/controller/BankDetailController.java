package com.example.backend.controller;

import com.example.backend.entity.BankDetail;
import com.example.backend.repository.BankDetailRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bank-details")
@CrossOrigin(origins = "http://localhost:5173")
public class BankDetailController {

    private final BankDetailRepository repository;

    public BankDetailController(BankDetailRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<BankDetail> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankDetail> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public BankDetail create(@RequestBody BankDetail item) {
        return repository.save(item);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BankDetail> update(
            @PathVariable Long id,
            @RequestBody BankDetail updated) {

        return repository.findById(id).map(existing -> {
            existing.setBankCode(updated.getBankCode());
            existing.setBankName(updated.getBankName());
            existing.setStandardBankName(updated.getStandardBankName());

            return ResponseEntity.ok(repository.save(existing));
        }).orElse(ResponseEntity.notFound().build());
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

