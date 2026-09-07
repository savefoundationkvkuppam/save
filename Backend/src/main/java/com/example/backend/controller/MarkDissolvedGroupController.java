package com.example.backend.controller;

import com.example.backend.entity.MarkDissolvedGroup;
import com.example.backend.repository.MarkDissolvedGroupRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mark-dissolved-groups")
@CrossOrigin(origins = "http://localhost:5173")
public class MarkDissolvedGroupController {
    private final MarkDissolvedGroupRepository repository;

    public MarkDissolvedGroupController(MarkDissolvedGroupRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<MarkDissolvedGroup> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarkDissolvedGroup> getById(@PathVariable Long id) {
        return repository.findById(id).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public MarkDissolvedGroup create(@RequestBody MarkDissolvedGroup record) {
        return repository.save(record);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MarkDissolvedGroup> update(@PathVariable Long id,
                                                       @RequestBody MarkDissolvedGroup updated) {
        return repository.findById(id).map(existing -> {
            existing.setGroupName(updated.getGroupName());
            existing.setMarkedDissolved(updated.isMarkedDissolved());
            existing.setReason(updated.getReason());
            return ResponseEntity.ok(repository.save(existing));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repository.existsById(id)) return ResponseEntity.notFound().build();
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

