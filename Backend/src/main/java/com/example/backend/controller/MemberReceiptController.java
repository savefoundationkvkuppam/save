package com.example.backend.controller;

import com.example.backend.entity.MemberReceipt;
import com.example.backend.repository.MemberReceiptRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/member-receipts")
@CrossOrigin(origins = "http://localhost:5173")
public class MemberReceiptController {

    private final MemberReceiptRepository repository;

    public MemberReceiptController(MemberReceiptRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<MemberReceipt> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public MemberReceipt create(@RequestBody MemberReceipt receipt) {
        return repository.save(receipt);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberReceipt> update(
            @PathVariable Long id,
            @RequestBody MemberReceipt details) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setReceiptNo(details.getReceiptNo());
                    existing.setReceiptDate(details.getReceiptDate());
                    existing.setCash(details.getCash());
                    existing.setAccountType(details.getAccountType());
                    existing.setBranch(details.getBranch());
                    existing.setAccountNo(details.getAccountNo());
                    existing.setChequeNo(details.getChequeNo());
                    existing.setMemberCode(details.getMemberCode());
                    existing.setMemberName(details.getMemberName());
                    existing.setRegularSavings(details.getRegularSavings());
                    existing.setBulletSavings(details.getBulletSavings());
                    existing.setSpecialSavings(details.getSpecialSavings());
                    existing.setSpecialSavingsAmount(details.getSpecialSavingsAmount());
                    existing.setSpecialSavingsMoreType(details.getSpecialSavingsMoreType());
                    existing.setSpecialSavingsMoreAmount(details.getSpecialSavingsMoreAmount());
                    existing.setLivelihoodLoanSupport1(details.getLivelihoodLoanSupport1());
                    existing.setServiceCost1(details.getServiceCost1());
                    existing.setLivelihoodLoanSupport2(details.getLivelihoodLoanSupport2());
                    existing.setServiceCost2(details.getServiceCost2());
                    existing.setHousingLoan(details.getHousingLoan());
                    existing.setHousingServiceCost(details.getHousingServiceCost());
                    existing.setTotal(details.getTotal());
                    existing.setAdditionalDetails(details.getAdditionalDetails());
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
