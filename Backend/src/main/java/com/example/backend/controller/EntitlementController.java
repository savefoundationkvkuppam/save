package com.example.backend.controller;

import com.example.backend.entity.Entitlement;
import com.example.backend.repository.EntitlementRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/entitlements")
@CrossOrigin(origins = "http://localhost:5173")
public class EntitlementController {
    private final EntitlementRepository repository;
    public EntitlementController(EntitlementRepository repository) { this.repository = repository; }

    @GetMapping
    public List<Entitlement> getAll() { return repository.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Entitlement> getById(@PathVariable Long id) {
        return repository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/member/{memberId}")
    public List<Entitlement> getByMemberId(@PathVariable Long memberId) { return repository.findByMemberId(memberId); }

    @PostMapping
    public Entitlement create(@RequestBody Entitlement entitlement) { return repository.save(entitlement); }

    @PutMapping("/{id}")
    public ResponseEntity<Entitlement> update(@PathVariable Long id, @RequestBody Entitlement updated) {
        return repository.findById(id).map(existing -> {
            existing.setMemberId(updated.getMemberId());
            existing.setMemberName(updated.getMemberName());
            existing.setFamilyMember(updated.getFamilyMember());
            existing.setVoterIdCard(updated.getVoterIdCard());
            existing.setBankAccount(updated.getBankAccount());
            existing.setAadharCard(updated.getAadharCard());
            existing.setRationCard(updated.getRationCard());
            existing.setDrivingLicense(updated.getDrivingLicense());
            existing.setEsiCard(updated.getEsiCard());
            existing.setKissanCard(updated.getKissanCard());
            existing.setGovtHealthCard(updated.getGovtHealthCard());
            existing.setOap(updated.getOap());
            existing.setWidowPension(updated.getWidowPension());
            existing.setMarriageScheme(updated.getMarriageScheme());
            existing.setAbiy(updated.getAbiy());
            existing.setPmjjby(updated.getPmjjby());
            existing.setPmjsby(updated.getPmjsby());
            existing.setMicroPension(updated.getMicroPension());
            existing.setHealthInsurance(updated.getHealthInsurance());
            existing.setAtalPension(updated.getAtalPension());
            existing.setMgnrega(updated.getMgnrega());
            existing.setLabourCard(updated.getLabourCard());
            existing.setHouseScheme(updated.getHouseScheme());
            existing.setVendorLicense(updated.getVendorLicense());
            existing.setOthers(updated.getOthers());
            return ResponseEntity.ok(repository.save(existing));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repository.existsById(id)) return ResponseEntity.notFound().build();
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

