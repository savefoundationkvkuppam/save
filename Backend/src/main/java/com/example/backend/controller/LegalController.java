package com.example.backend.controller;

import com.example.backend.entity.Legal;
import com.example.backend.repository.LegalRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/legals")
@CrossOrigin(origins = "http://localhost:5173")
public class LegalController {

    private final LegalRepository repository;

    public LegalController(LegalRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Legal> getAll() { return repository.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Legal> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/member/{memberId}")
    public List<Legal> getByMemberId(@PathVariable Long memberId) {
        return repository.findByMemberId(memberId);
    }

    @PostMapping
    public Legal create(@RequestBody Legal legal) { return repository.save(legal); }

    @PutMapping("/{id}")
    public ResponseEntity<Legal> update(@PathVariable Long id, @RequestBody Legal updated) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setMemberId(updated.getMemberId());
                    existing.setVazhvatharamCode(updated.getVazhvatharamCode());
                    existing.setMemberName(updated.getMemberName());
                    existing.setParticulars(updated.getParticulars());
                    existing.setDisputeDetails(updated.getDisputeDetails());
                    return ResponseEntity.ok(repository.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repository.existsById(id)) return ResponseEntity.notFound().build();
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
