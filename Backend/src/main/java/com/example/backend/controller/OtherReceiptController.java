package com.example.backend.controller;

import com.example.backend.entity.OtherReceipt;
import com.example.backend.repository.OtherReceiptRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/other-receipts")
public class OtherReceiptController {

    private final OtherReceiptRepository repository;

    public OtherReceiptController(OtherReceiptRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<OtherReceipt> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OtherReceipt> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public OtherReceipt create(@RequestBody OtherReceipt receipt) {
        return repository.save(receipt);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OtherReceipt> update(
            @PathVariable Long id,
            @RequestBody OtherReceipt updated) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setReceiptNo(updated.getReceiptNo());
                    existing.setReceiptDate(updated.getReceiptDate());
                    existing.setReceiptType(updated.getReceiptType());
                    existing.setAccountType(updated.getAccountType());
                    existing.setBankBranch(updated.getBankBranch());
                    existing.setAccountNo(updated.getAccountNo());
                    existing.setChequeNo(updated.getChequeNo());
                    existing.setSubLedger(updated.getSubLedger());
                    existing.setAmount(updated.getAmount());
                    existing.setMore(updated.getMore());
                    existing.setLinkageBranch(updated.getLinkageBranch());
                    existing.setLoanNo(updated.getLoanNo());
                    existing.setBankPeriod(updated.getBankPeriod());
                    existing.setInterestRate(updated.getInterestRate());
                    existing.setSubLedgerLines(updated.getSubLedgerLines());
                    existing.setNarration(updated.getNarration());
                    existing.setTotal(updated.getTotal());
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
