package com.example.backend.controller;

import com.example.backend.entity.MutualLifeEnrollment;
import com.example.backend.repository.MutualLifeEnrollmentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mutual-life/enrollments")
public class MutualLifeEnrollmentController {

    private final MutualLifeEnrollmentRepository repository;

    public MutualLifeEnrollmentController(MutualLifeEnrollmentRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<MutualLifeEnrollment> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MutualLifeEnrollment> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public MutualLifeEnrollment create(@RequestBody MutualLifeEnrollment record) {
        return repository.save(record);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MutualLifeEnrollment> update(@PathVariable Long id, @RequestBody MutualLifeEnrollment updated) {
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

    private void copyFields(MutualLifeEnrollment target, MutualLifeEnrollment source) {
        // fields copied by the generated entity contract
        target.setIdNo(source.getIdNo());
        target.setMemberName(source.getMemberName());
        target.setInsurerName(source.getInsurerName());
        target.setRelationshipWithMember(source.getRelationshipWithMember());
        target.setGender(source.getGender());
        target.setNomineeName(source.getNomineeName());
        target.setNomineeRelationWithInsurer(source.getNomineeRelationWithInsurer());
        target.setAgeProof(source.getAgeProof());
        target.setCardNo(source.getCardNo());
        target.setReceiptNumber(source.getReceiptNumber());
        target.setReceiptDate(source.getReceiptDate());
        target.setReceiptAmount(source.getReceiptAmount());
        target.setCompanyName(source.getCompanyName());
        target.setInsuranceScheme(source.getInsuranceScheme());
    }
}

