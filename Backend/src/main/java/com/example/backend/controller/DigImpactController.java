package com.example.backend.controller;

import com.example.backend.entity.DigImpact;
import com.example.backend.repository.DigImpactRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dig-impact")
public class DigImpactController {

    private final DigImpactRepository repository;

    public DigImpactController(DigImpactRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<DigImpact> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DigImpact> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public DigImpact create(@RequestBody DigImpact digImpact) {
        return repository.save(digImpact);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DigImpact> update(
            @PathVariable Long id,
            @RequestBody DigImpact updated) {

        return repository.findById(id)
                .map(existing -> {
                    existing.setMapDigId(updated.getMapDigId());
                    existing.setGroupName(updated.getGroupName());
                    existing.setPurpose(updated.getPurpose());
                    existing.setImpactStatus(updated.getImpactStatus());
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
