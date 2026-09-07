package com.example.backend.controller;

import com.example.backend.entity.BankLoanNotNeeded;
import com.example.backend.repository.BankLoanNotNeededRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bank-loan-not-needed")
public class BankLoanNotNeededController {

    private final BankLoanNotNeededRepository repository;

    public BankLoanNotNeededController(
            BankLoanNotNeededRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<BankLoanNotNeeded> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankLoanNotNeeded> getById(
            @PathVariable Long id) {

        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public BankLoanNotNeeded create(
            @RequestBody BankLoanNotNeeded bankLoanNotNeeded) {

        return repository.save(bankLoanNotNeeded);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BankLoanNotNeeded> update(
            @PathVariable Long id,
            @RequestBody BankLoanNotNeeded updated) {

        return repository.findById(id)
                .map(existing -> {
                    existing.setVazhvathram(updated.getVazhvathram());
                    existing.setDontNeedBkLn(updated.isDontNeedBkLn());
                    existing.setReason(updated.getReason());

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

