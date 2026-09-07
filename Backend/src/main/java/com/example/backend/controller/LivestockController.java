package com.example.backend.controller;

import com.example.backend.entity.Livestock;
import com.example.backend.repository.LivestockRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livestocks")
@CrossOrigin(origins = "*")
public class LivestockController {

    private final LivestockRepository repository;

    public LivestockController(LivestockRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Livestock> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livestock> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/member/{memberId}")
    public List<Livestock> getByMemberId(@PathVariable Long memberId) {
        return repository.findByMemberId(memberId);
    }

    @PostMapping
    public Livestock create(@RequestBody Livestock livestock) {
        return repository.save(livestock);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livestock> update(
            @PathVariable Long id,
            @RequestBody Livestock updated) {

        return repository.findById(id)
                .map(existing -> {
                    existing.setMemberId(updated.getMemberId());
                    existing.setMemberName(updated.getMemberName());
                    existing.setLivestock(updated.getLivestock());
                    existing.setQuantity(updated.getQuantity());
                    existing.setPresentValue(updated.getPresentValue());
                    existing.setAnnualIncome(updated.getAnnualIncome());
                    existing.setInsurance(updated.getInsurance());
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

