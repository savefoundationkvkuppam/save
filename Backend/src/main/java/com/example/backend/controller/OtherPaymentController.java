package com.example.backend.controller;

import com.example.backend.entity.OtherPayment;
import com.example.backend.repository.OtherPaymentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/other-payments")
public class OtherPaymentController {
    private final OtherPaymentRepository repository;

    public OtherPaymentController(OtherPaymentRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<OtherPayment> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OtherPayment> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public OtherPayment create(@RequestBody OtherPayment payment) {
        return repository.save(payment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OtherPayment> update(
            @PathVariable Long id,
            @RequestBody OtherPayment updated) {
        return repository.findById(id).map(existing -> {
            existing.setVoucherNo(updated.getVoucherNo());
            existing.setVoucherDate(updated.getVoucherDate());
            existing.setVoucherType(updated.getVoucherType());
            existing.setAccountType(updated.getAccountType());
            existing.setBankBranch(updated.getBankBranch());
            existing.setAccountNo(updated.getAccountNo());
            existing.setChequeNo(updated.getChequeNo());
            existing.setShg(updated.getShg());
            existing.setSahayaCovid(updated.getSahayaCovid());
            existing.setRoc(updated.getRoc());
            existing.setKdfsCovid(updated.getKdfsCovid());
            existing.setMfKdfs(updated.getMfKdfs());
            existing.setRocKdfs(updated.getRocKdfs());
            existing.setUpnrmKdfs(updated.getUpnrmKdfs());
            existing.setHope(updated.getHope());
            existing.setBankLoanPrincipalDate(updated.getBankLoanPrincipalDate());
            existing.setSl(updated.getSl());
            existing.setCashDepositedDate(updated.getCashDepositedDate());
            existing.setAmount(updated.getAmount());
            existing.setAmountType(updated.getAmountType());
            existing.setSubLed1(updated.getSubLed1()); existing.setAmt1(updated.getAmt1());
            existing.setSubLed2(updated.getSubLed2()); existing.setAmt2(updated.getAmt2());
            existing.setSubLed3(updated.getSubLed3()); existing.setAmt3(updated.getAmt3());
            existing.setSubLed4(updated.getSubLed4()); existing.setAmt4(updated.getAmt4());
            existing.setSubLed5(updated.getSubLed5()); existing.setAmt5(updated.getAmt5());
            existing.setSubLed6(updated.getSubLed6()); existing.setAmt6(updated.getAmt6());
            existing.setSubLed7(updated.getSubLed7()); existing.setAmt7(updated.getAmt7());
            existing.setSubLed8(updated.getSubLed8()); existing.setAmt8(updated.getAmt8());
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
