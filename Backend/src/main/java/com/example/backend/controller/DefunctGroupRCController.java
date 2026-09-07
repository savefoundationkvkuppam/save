package com.example.backend.controller;

import com.example.backend.entity.DefunctGroupRC;
import com.example.backend.repository.DefunctGroupRCRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/defunct-group-rc")
public class DefunctGroupRCController {

    private final DefunctGroupRCRepository repository;

    public DefunctGroupRCController(DefunctGroupRCRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<DefunctGroupRC> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DefunctGroupRC> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public DefunctGroupRC create(@RequestBody DefunctGroupRC group) {
        return repository.save(group);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DefunctGroupRC> update(
            @PathVariable Long id,
            @RequestBody DefunctGroupRC updated) {

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
