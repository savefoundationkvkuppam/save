package com.example.backend.controller;

import com.example.backend.entity.Panchayat;
import com.example.backend.repository.PanchayatRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/panchayats")
@CrossOrigin(origins = "http://localhost:5173")
public class PanchayatController {

    private final PanchayatRepository repository;

    public PanchayatController(PanchayatRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Panchayat> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Panchayat> getById(
            @PathVariable Long id) {

        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Panchayat create(
            @RequestBody Panchayat panchayat) {

        return repository.save(panchayat);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Panchayat> update(
            @PathVariable Long id,
            @RequestBody Panchayat updated) {

        return repository.findById(id)
                .map(existing -> {

                    existing.setPanchayatUnionName(
                            updated.getPanchayatUnionName());

                    existing.setPanchayatWard(
                            updated.getPanchayatWard());

                    existing.setCode(
                            updated.getCode());

                    existing.setName(
                            updated.getName());

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