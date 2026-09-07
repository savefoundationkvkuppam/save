package com.example.backend.controller;

import com.example.backend.entity.Livelihood;
import com.example.backend.repository.LivelihoodRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livelihoods")
public class LivelihoodController {

    private final LivelihoodRepository repository;

    public LivelihoodController(LivelihoodRepository repository) {
        this.repository = repository;
    }

    // Get all livelihood records
    @GetMapping
    public List<Livelihood> getAll() {
        return repository.findAll();
    }

    // Get livelihood records for a particular member
    @GetMapping("/member/{memberId}")
    public List<Livelihood> getByMemberId(
            @PathVariable Long memberId) {

        return repository.findByMemberId(memberId);
    }

    // Get one livelihood record
    @GetMapping("/{id}")
    public ResponseEntity<Livelihood> getById(
            @PathVariable Long id) {

        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Add livelihood record
    @PostMapping
    public Livelihood create(
            @RequestBody Livelihood livelihood) {

        return repository.save(livelihood);
    }

    // Update livelihood record
    @PutMapping("/{id}")
    public ResponseEntity<Livelihood> update(
            @PathVariable Long id,
            @RequestBody Livelihood updated) {

        return repository.findById(id)
                .map(existing -> {

                    existing.setMemberId(
                            updated.getMemberId());

                    existing.setMemberName(
                            updated.getMemberName());

                    existing.setFamilyMember(
                            updated.getFamilyMember());

                    existing.setMasterOccupation(
                            updated.getMasterOccupation());

                    existing.setPrimaryOccupation(
                            updated.getPrimaryOccupation());

                    existing.setPrimaryMonthlyIncome(
                            updated.getPrimaryMonthlyIncome());

                    existing.setSecondaryMasterOccupation(
                            updated.getSecondaryMasterOccupation());

                    existing.setSecondaryOccupation(
                            updated.getSecondaryOccupation());

                    existing.setSecondaryMonthlyIncome(
                            updated.getSecondaryMonthlyIncome());

                    existing.setTotalIncome(
                            updated.getTotalIncome());

                    return ResponseEntity.ok(
                            repository.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete livelihood record
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
