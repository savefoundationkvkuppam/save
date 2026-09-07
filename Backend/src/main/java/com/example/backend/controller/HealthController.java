package com.example.backend.controller;

import com.example.backend.entity.Health;
import com.example.backend.repository.HealthRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/healths")
@CrossOrigin(origins = "http://localhost:5173")
public class HealthController {

    private final HealthRepository repository;

    public HealthController(HealthRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Health> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Health> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/member/{memberId}")
    public List<Health> getByMemberId(@PathVariable Long memberId) {
        return repository.findByMemberId(memberId);
    }

    @PostMapping
    public Health create(@RequestBody Health health) {
        return repository.save(health);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Health> update(
            @PathVariable Long id,
            @RequestBody Health updated) {

        return repository.findById(id)
                .map(existing -> {
                    existing.setMemberId(updated.getMemberId());
                    existing.setMemberName(updated.getMemberName());
                    existing.setFamilyMember(updated.getFamilyMember());
                    existing.setChronicIllness(updated.getChronicIllness());
                    existing.setHospitalReferred(updated.getHospitalReferred());
                    existing.setAlcoholism(updated.getAlcoholism());
                    existing.setAddictionYears(updated.getAddictionYears());
                    existing.setDifferentlyAbled(updated.getDifferentlyAbled());
                    existing.setDisabilityCard(updated.getDisabilityCard());
                    existing.setTransgender(updated.getTransgender());
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

