package com.example.backend.controller;

import com.example.backend.entity.MutualLifeCoverage;
import com.example.backend.repository.MutualLifeCoverageRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mutual-life/coverages")
public class MutualLifeCoverageController {

    private final MutualLifeCoverageRepository repository;

    public MutualLifeCoverageController(MutualLifeCoverageRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<MutualLifeCoverage> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MutualLifeCoverage> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public MutualLifeCoverage create(@RequestBody MutualLifeCoverage record) {
        return repository.save(record);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MutualLifeCoverage> update(@PathVariable Long id, @RequestBody MutualLifeCoverage updated) {
        return repository.findById(id)
                .map(existing -> {
                    copyFields(existing, updated);
                    return ResponseEntity.ok(repository.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repository.existsById(id)) return ResponseEntity.notFound().build();
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private void copyFields(MutualLifeCoverage target, MutualLifeCoverage source) {
        // fields copied by the generated entity contract
        target.setBatchNumber(source.getBatchNumber());
        target.setPolicyReceivedDate(source.getPolicyReceivedDate());
        target.setMasterPolicyNumber(source.getMasterPolicyNumber());
        target.setCoverageStartingDate(source.getCoverageStartingDate());
        target.setCoverageEndingDate(source.getCoverageEndingDate());
    }
}

