package com.example.backend.controller;

import com.example.backend.entity.Village;
import com.example.backend.repository.VillageRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/villages")
@CrossOrigin(origins = "http://localhost:5173")
public class VillageController {

    private final VillageRepository repository;

    public VillageController(VillageRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Village> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Village> getById(
            @PathVariable Long id) {

        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Village create(
            @RequestBody Village village) {

        return repository.save(village);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Village> update(
            @PathVariable Long id,
            @RequestBody Village updated) {

        return repository.findById(id)
                .map(existing -> {

                    existing.setPanchayatName(
                            updated.getPanchayatName());

                    existing.setVillageSlum(
                            updated.getVillageSlum());

                    existing.setCode(
                            updated.getCode());

                    existing.setName(
                            updated.getName());

                    existing.setPinCode(
                            updated.getPinCode());

                    return ResponseEntity.ok(
                            repository.save(existing));
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