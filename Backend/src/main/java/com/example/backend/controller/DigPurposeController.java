package com.example.backend.controller;

import com.example.backend.entity.DigPurpose;
import com.example.backend.repository.DigPurposeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dig-purposes")
@CrossOrigin(origins = "http://localhost:5173")
public class DigPurposeController {

    private final DigPurposeRepository repository;

    public DigPurposeController(DigPurposeRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<DigPurpose> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public DigPurpose create(@RequestBody DigPurpose digPurpose) {
        return repository.save(digPurpose);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DigPurpose> update(
            @PathVariable Long id,
            @RequestBody DigPurpose incoming) {

        return repository.findById(id)
                .map(existing -> {
                    existing.setCode(incoming.getCode());
                    existing.setName(incoming.getName());
                    existing.setClassification(incoming.getClassification());
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

