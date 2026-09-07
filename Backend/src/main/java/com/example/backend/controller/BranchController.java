package com.example.backend.controller;

import com.example.backend.entity.Branch;
import com.example.backend.repository.BranchRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/branches")
@CrossOrigin(origins = "http://localhost:5173")
public class BranchController {

    private final BranchRepository repository;

    public BranchController(BranchRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Branch> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Branch> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Branch create(@RequestBody Branch item) {
        return repository.save(item);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Branch> update(
            @PathVariable Long id,
            @RequestBody Branch updated) {

        return repository.findById(id).map(existing -> {
            existing.setBankName(updated.getBankName());
            existing.setBranchCode(updated.getBranchCode());
            existing.setBranchName(updated.getBranchName());
            existing.setAddress1(updated.getAddress1());
            existing.setAddress2(updated.getAddress2());
            existing.setState(updated.getState());
            existing.setDistrict(updated.getDistrict());
            existing.setPinCode(updated.getPinCode());
            existing.setPhone(updated.getPhone());
            existing.setIfscCode(updated.getIfscCode());

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

