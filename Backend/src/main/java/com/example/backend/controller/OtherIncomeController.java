package com.example.backend.controller;

import com.example.backend.entity.OtherIncome;
import com.example.backend.repository.OtherIncomeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/other-incomes")
public class OtherIncomeController {

    private final OtherIncomeRepository repository;

    public OtherIncomeController(OtherIncomeRepository repository) {
        this.repository = repository;
    }

    // Get all Other Income records
    @GetMapping
    public List<OtherIncome> getAll() {
        return repository.findAll();
    }

    // Get Other Income records for a particular member
    @GetMapping("/member/{memberId}")
    public List<OtherIncome> getByMemberId(
            @PathVariable Long memberId) {

        return repository.findByMemberId(memberId);
    }

    // Get one Other Income record
    @GetMapping("/{id}")
    public ResponseEntity<OtherIncome> getById(
            @PathVariable Long id) {

        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Add Other Income record
    @PostMapping
    public OtherIncome create(
            @RequestBody OtherIncome otherIncome) {

        return repository.save(otherIncome);
    }

    // Update Other Income record
    @PutMapping("/{id}")
    public ResponseEntity<OtherIncome> update(
            @PathVariable Long id,
            @RequestBody OtherIncome updated) {

        return repository.findById(id)
                .map(existing -> {

                    existing.setMemberId(
                            updated.getMemberId());

                    existing.setMemberName(
                            updated.getMemberName());

                    existing.setHouseRent(
                            updated.getHouseRent());

                    existing.setEmptyLandRent(
                            updated.getEmptyLandRent());

                    return ResponseEntity.ok(
                            repository.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete Other Income record
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
