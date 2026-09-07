package com.example.backend.controller;

import com.example.backend.entity.Taluk;
import com.example.backend.repository.TalukRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/taluks")
public class TalukController {

    private final TalukRepository repository;

    public TalukController(TalukRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Taluk> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Taluk> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Taluk create(@RequestBody Taluk taluk) {
        return repository.save(taluk);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Taluk> update(
            @PathVariable Long id,
            @RequestBody Taluk updated) {

        return repository.findById(id)
                .map(existing -> {

                    existing.setTalukCode(updated.getTalukCode());
                    existing.setDistrictName(updated.getDistrictName());
                    existing.setTalukName(updated.getTalukName());

                    return ResponseEntity.ok(
                            repository.save(existing)
                    );
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