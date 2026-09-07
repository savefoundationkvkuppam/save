package com.example.backend.controller;

import com.example.backend.entity.BankAccount;
import com.example.backend.repository.BankAccountRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bank-accounts")
@CrossOrigin(origins = "http://localhost:5173")
public class BankAccountController {

    private final BankAccountRepository repository;

    public BankAccountController(BankAccountRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<BankAccount> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankAccount> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/member/{memberId}")
    public List<BankAccount> getByMemberId(@PathVariable Long memberId) {
        return repository.findByMemberId(memberId);
    }

    @PostMapping
    public BankAccount create(@RequestBody BankAccount bankAccount) {
        return repository.save(bankAccount);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BankAccount> update(
            @PathVariable Long id,
            @RequestBody BankAccount updated) {

        return repository.findById(id)
                .map(existing -> {
                    existing.setBankName(updated.getBankName());
                    existing.setBranchName(updated.getBranchName());
                    existing.setAccountType(updated.getAccountType());
                    existing.setAccountNumber(updated.getAccountNumber());
                    existing.setAccountDate(updated.getAccountDate());
                    existing.setAmount(updated.getAmount());

                    existing.setMemberId(updated.getMemberId());
                    existing.setMemberName(updated.getMemberName());
                    existing.setFamilyMemberNo(updated.getFamilyMemberNo());
                    existing.setBankAccountName(updated.getBankAccountName());
                    existing.setBranchDetails(updated.getBranchDetails());
                    existing.setAadharCardNumber(updated.getAadharCardNumber());

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
