package com.example.backend.controller;

import com.example.backend.entity.MutualLifeClaim;
import com.example.backend.repository.MutualLifeClaimRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mutual-life/claims")
public class MutualLifeClaimController {

    private final MutualLifeClaimRepository repository;

    public MutualLifeClaimController(MutualLifeClaimRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<MutualLifeClaim> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MutualLifeClaim> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public MutualLifeClaim create(@RequestBody MutualLifeClaim record) {
        return repository.save(record);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MutualLifeClaim> update(@PathVariable Long id, @RequestBody MutualLifeClaim updated) {
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

    private void copyFields(MutualLifeClaim target, MutualLifeClaim source) {
        // fields copied by the generated entity contract
        target.setMemberName(source.getMemberName());
        target.setClaimNo(source.getClaimNo());
        target.setInsurerName(source.getInsurerName());
        target.setClaimReceivedDate(source.getClaimReceivedDate());
        target.setBenefitType(source.getBenefitType());
        target.setBenefitAmount(source.getBenefitAmount());
        target.setCauseOfDeath(source.getCauseOfDeath());
        target.setBankName(source.getBankName());
        target.setDateOfDeath(source.getDateOfDeath());
        target.setBranchName(source.getBranchName());
        target.setSbAccountNo(source.getSbAccountNo());
        target.setPlaceOfEvent(source.getPlaceOfEvent());
        target.setNomineeName(source.getNomineeName());
        target.setUtilization(source.getUtilization());
    }
}

