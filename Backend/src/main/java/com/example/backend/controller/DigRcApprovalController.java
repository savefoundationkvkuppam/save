package com.example.backend.controller;

import com.example.backend.entity.DigRcApproval;
import com.example.backend.repository.DigRcApprovalRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dig-rc-approval")
public class DigRcApprovalController {

    private final DigRcApprovalRepository repository;

    public DigRcApprovalController(DigRcApprovalRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<DigRcApproval> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DigRcApproval> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public DigRcApproval create(@RequestBody DigRcApproval approval) {
        return repository.save(approval);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DigRcApproval> update(
            @PathVariable Long id,
            @RequestBody DigRcApproval updated) {

        return repository.findById(id)
                .map(existing -> {
                    existing.setMapDigId(updated.getMapDigId());
                    existing.setGroupName(updated.getGroupName());
                    existing.setApproved(updated.isApproved());
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
