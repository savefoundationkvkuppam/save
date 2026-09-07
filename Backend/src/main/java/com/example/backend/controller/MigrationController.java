package com.example.backend.controller;

import com.example.backend.entity.Migration;
import com.example.backend.repository.MigrationRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/migrations")
@CrossOrigin(origins = "*")
public class MigrationController {

    private final MigrationRepository repository;

    public MigrationController(MigrationRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Migration> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Migration> getById(@PathVariable Long id) {

        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/member/{memberId}")
    public List<Migration> getByMemberId(
            @PathVariable Long memberId) {

        return repository.findByMemberId(memberId);
    }

    @PostMapping
    public Migration create(@RequestBody Migration migration) {
        return repository.save(migration);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Migration> update(
            @PathVariable Long id,
            @RequestBody Migration updated) {

        return repository.findById(id)
                .map(existing -> {

                    existing.setMemberId(
                            updated.getMemberId());

                    existing.setMemberName(
                            updated.getMemberName());

                    existing.setFamilyMember(
                            updated.getFamilyMember());

                    existing.setPlaceOfMigration(
                            updated.getPlaceOfMigration());

                    existing.setNatureOfOccupation(
                            updated.getNatureOfOccupation());

                    existing.setPeriodOfMigration(
                            updated.getPeriodOfMigration());

                    existing.setMonthlyIncome(
                            updated.getMonthlyIncome());

                    return ResponseEntity.ok(
                            repository.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

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
