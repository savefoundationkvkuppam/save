package com.example.backend.controller;

import com.example.backend.entity.PanchayatUnion;
import com.example.backend.repository.PanchayatUnionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/panchayat-unions")
public class PanchayatUnionController {

    private final PanchayatUnionRepository repository;

    public PanchayatUnionController(PanchayatUnionRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<PanchayatUnion> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PanchayatUnion> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public PanchayatUnion create(@RequestBody PanchayatUnion panchayatUnion) {
        return repository.save(panchayatUnion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PanchayatUnion> update(
            @PathVariable Long id,
            @RequestBody PanchayatUnion updated) {

        return repository.findById(id)
                .map(existing -> {
                    existing.setPanchayatUnionCode(updated.getPanchayatUnionCode());
                    existing.setDistrictName(updated.getDistrictName());
                    existing.setTalukName(updated.getTalukName());
                    existing.setPanchayatUnionName(updated.getPanchayatUnionName());
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
 
