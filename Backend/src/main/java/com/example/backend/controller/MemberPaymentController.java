package com.example.backend.controller;

import com.example.backend.entity.MemberPayment;
import com.example.backend.repository.MemberPaymentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/member-payments")
public class MemberPaymentController {
    private final MemberPaymentRepository repository;

    public MemberPaymentController(MemberPaymentRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<MemberPayment> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberPayment> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public MemberPayment create(@RequestBody MemberPayment payment) {
        return repository.save(payment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberPayment> update(@PathVariable Long id, @RequestBody MemberPayment updated) {
        return repository.findById(id).map(existing -> {
            existing.setVoucherNo(updated.getVoucherNo());
            existing.setVoucherDate(updated.getVoucherDate());
            existing.setMemberCode(updated.getMemberCode());
            existing.setMemberName(updated.getMemberName());
            existing.setVoucherType(updated.getVoucherType());
            existing.setAccountType(updated.getAccountType());
            existing.setBankBranch(updated.getBankBranch());
            existing.setAccountNo(updated.getAccountNo());
            existing.setChequeNo(updated.getChequeNo());
            existing.setSavings(updated.getSavings());
            existing.setSavingsIncentive(updated.getSavingsIncentive());
            existing.setBulletSavings(updated.getBulletSavings());
            existing.setSocialSecurityType(updated.getSocialSecurityType());
            existing.setSocialSecurityAmount(updated.getSocialSecurityAmount());
            existing.setSpecialSavingsType(updated.getSpecialSavingsType());
            existing.setSpecialSavingsAmount(updated.getSpecialSavingsAmount());
            existing.setSpecialSavingsMoreType(updated.getSpecialSavingsMoreType());
            existing.setSpecialSavingsMoreAmount(updated.getSpecialSavingsMoreAmount());
            existing.setSpecialSavingsIncentive(updated.getSpecialSavingsIncentive());
            existing.setLoanType(updated.getLoanType());
            existing.setLoanAmount(updated.getLoanAmount());
            existing.setInstalmentAmount(updated.getInstalmentAmount());
            existing.setInstalmentType(updated.getInstalmentType());
            existing.setPurpose(updated.getPurpose());
            existing.setSubPurpose(updated.getSubPurpose());
            existing.setNarration(updated.getNarration());
            existing.setTotal(updated.getTotal());
            return ResponseEntity.ok(repository.save(existing));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repository.existsById(id)) return ResponseEntity.notFound().build();
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

