package com.example.backend.controller;

import com.example.backend.entity.PanUnion;
import com.example.backend.repository.PanUnionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pan-unions")
@CrossOrigin(origins = "http://localhost:5173")
public class PanUnionController {

    private final PanUnionRepository repository;

    public PanUnionController(PanUnionRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<PanUnion> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PanUnion> getById(
            @PathVariable Long id) {

        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public PanUnion create(
            @RequestBody PanUnion panUnion) {

        return repository.save(panUnion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PanUnion> update(
            @PathVariable Long id,
            @RequestBody PanUnion updated) {

        return repository.findById(id)
                .map(existing -> {

                    existing.setPanUnionCode(
                            updated.getPanUnionCode());

                    existing.setDistrictName(
                            updated.getDistrictName());

                    existing.setPanUnionName(
                            updated.getPanUnionName());

                    return ResponseEntity.ok(
                            repository.save(existing)
                    );
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}