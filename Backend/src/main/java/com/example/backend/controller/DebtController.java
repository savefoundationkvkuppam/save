package com.example.backend.controller;

import com.example.backend.entity.Debt;
import com.example.backend.repository.DebtRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/debts")
public class DebtController {
    private final DebtRepository repository;
    public DebtController(DebtRepository repository){this.repository=repository;}

    @GetMapping public List<Debt> getAll(){return repository.findAll();}
    @GetMapping("/{id}") public ResponseEntity<Debt> getById(@PathVariable Long id){
        return repository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/member/{memberId}") public List<Debt> getByMember(@PathVariable Long memberId){return repository.findByMemberId(memberId);}
    @PostMapping public Debt create(@RequestBody Debt debt){return repository.save(debt);}
    @PutMapping("/{id}") public ResponseEntity<Debt> update(@PathVariable Long id,@RequestBody Debt updated){
        return repository.findById(id).map(existing->{
            existing.setMemberId(updated.getMemberId()); existing.setMemberName(updated.getMemberName());
            existing.setDebtType(updated.getDebtType()); existing.setSource(updated.getSource());
            existing.setLoanAmount(updated.getLoanAmount()); existing.setPresentOutstanding(updated.getPresentOutstanding());
            existing.setBorrowingYear(updated.getBorrowingYear()); existing.setInterestRate(updated.getInterestRate());
            existing.setLoanPurpose(updated.getLoanPurpose()); existing.setRepaymentFrequency(updated.getRepaymentFrequency());
            return ResponseEntity.ok(repository.save(existing));
        }).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id){
        if(!repository.existsById(id)) return ResponseEntity.notFound().build();
        repository.deleteById(id); return ResponseEntity.noContent().build();
    }
}

