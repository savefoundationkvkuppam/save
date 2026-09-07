package com.example.backend.controller;

import com.example.backend.entity.MutualLifeScholarship;
import com.example.backend.repository.MutualLifeScholarshipRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mutual-life/scholarships")
public class MutualLifeScholarshipController {

    private final MutualLifeScholarshipRepository repository;

    public MutualLifeScholarshipController(MutualLifeScholarshipRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<MutualLifeScholarship> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MutualLifeScholarship> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public MutualLifeScholarship create(@RequestBody MutualLifeScholarship record) {
        return repository.save(record);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MutualLifeScholarship> update(@PathVariable Long id, @RequestBody MutualLifeScholarship updated) {
        return repository.findById(id)
                .map(existing -> {
                    copyFields(existing, updated);
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

    private void copyFields(MutualLifeScholarship target, MutualLifeScholarship source) {
        // fields copied by the generated entity contract
        target.setLicIdNo(source.getLicIdNo());
        target.setMemberName(source.getMemberName());
        target.setStudentName(source.getStudentName());
        target.setGender(source.getGender());
        target.setSchoolName(source.getSchoolName());
        target.setStandard(source.getStandard());
        target.setAccountHolderName(source.getAccountHolderName());
        target.setAccountNumber(source.getAccountNumber());
        target.setBankName(source.getBankName());
        target.setBranchName(source.getBranchName());
        target.setReceivedDate(source.getReceivedDate());
        target.setReceivedAmount(source.getReceivedAmount());
    }
}

