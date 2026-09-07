package com.example.backend.controller;

import com.example.backend.entity.Auditor;
import com.example.backend.repository.AuditorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auditors")
@CrossOrigin(origins = "http://localhost:5173")
public class AuditorController {

    private final AuditorRepository repository;

    public AuditorController(AuditorRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Auditor> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Auditor> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Auditor create(@RequestBody Auditor item) {
        return repository.save(item);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Auditor> update(
            @PathVariable Long id,
            @RequestBody Auditor updated) {

        return repository.findById(id).map(existing -> {
            existing.setAuditorName(updated.getAuditorName());
            existing.setAddress1(updated.getAddress1());
            existing.setAddress2(updated.getAddress2());
            existing.setState(updated.getState());
            existing.setDistrict(updated.getDistrict());
            existing.setPincode(updated.getPincode());
            existing.setPhone(updated.getPhone());

            return ResponseEntity.ok(repository.save(existing));
        }).orElse(ResponseEntity.notFound().build());
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
