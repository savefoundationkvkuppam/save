package com.example.backend.controller;

import com.example.backend.entity.DefunctGroup;
import com.example.backend.repository.DefunctGroupRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/defunct-groups")
public class DefunctGroupController {

    private final DefunctGroupRepository repository;

    public DefunctGroupController(DefunctGroupRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<DefunctGroup> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DefunctGroup> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public DefunctGroup create(@RequestBody DefunctGroup defunctGroup) {
        return repository.save(defunctGroup);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DefunctGroup> update(
            @PathVariable Long id,
            @RequestBody DefunctGroup updated) {

        return repository.findById(id)
                .map(existing -> {
                    existing.setGroupName(updated.getGroupName());
                    existing.setDefunct(updated.isDefunct());
                    existing.setNoOfMonths(updated.getNoOfMonths());
                    existing.setReason(updated.getReason());

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
