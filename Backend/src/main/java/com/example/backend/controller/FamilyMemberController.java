package com.example.backend.controller;

import com.example.backend.entity.FamilyMember;
import com.example.backend.repository.FamilyMemberRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/family-members")
public class FamilyMemberController {

    private final FamilyMemberRepository repository;

    public FamilyMemberController(FamilyMemberRepository repository) {
        this.repository = repository;
    }

    // Get all family members
    @GetMapping
    public List<FamilyMember> getAll() {
        return repository.findAll();
    }

    // Get family members for a particular member
    @GetMapping("/member/{memberId}")
    public List<FamilyMember> getByMemberId(
            @PathVariable Long memberId) {

        return repository.findByMemberId(memberId);
    }

    // Get one family member by ID
    @GetMapping("/{id}")
    public ResponseEntity<FamilyMember> getById(
            @PathVariable Long id) {

        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Add family member
    @PostMapping
    public FamilyMember create(
            @RequestBody FamilyMember familyMember) {

        return repository.save(familyMember);
    }

    // Update family member
    @PutMapping("/{id}")
    public ResponseEntity<FamilyMember> update(
            @PathVariable Long id,
            @RequestBody FamilyMember updated) {

        return repository.findById(id)
                .map(existing -> {

                    existing.setMemberId(
                            updated.getMemberId());

                    existing.setMemberName(
                            updated.getMemberName());

                    existing.setSerialNo(
                            updated.getSerialNo());

                    existing.setName(
                            updated.getName());

                    existing.setDateOfBirth(
                            updated.getDateOfBirth());

                    existing.setGender(
                            updated.getGender());

                    existing.setRelationship(
                            updated.getRelationship());

                    existing.setMaritalStatus(
                            updated.getMaritalStatus());

                    existing.setEducation(
                            updated.getEducation());

                    existing.setContinuingEducation(
                            updated.getContinuingEducation());

                    existing.setBloodGroup(
                            updated.getBloodGroup());

                    return ResponseEntity.ok(
                            repository.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete family member
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