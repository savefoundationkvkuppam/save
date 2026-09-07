package com.example.backend.controller;

import com.example.backend.entity.Vazhvathram;
import com.example.backend.repository.VazhvathramRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vazhvathrams")

public class VazhvathramController {

    private final VazhvathramRepository repository;

    public VazhvathramController(
            VazhvathramRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Vazhvathram create(
            @RequestBody Vazhvathram vazhvathram) {

        return repository.save(vazhvathram);
    }

    @GetMapping
    public List<Vazhvathram> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vazhvathram> getById(
            @PathVariable Long id) {

        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vazhvathram> update(
            @PathVariable Long id,
            @RequestBody Vazhvathram updated) {

        return repository.findById(id)
                .map(existing -> {

                    existing.setVazhvathramCode(
                            updated.getVazhvathramCode());

                    existing.setVazhvathramCodeSecond(
                            updated.getVazhvathramCodeSecond());

                    existing.setVazhvathramName(
                            updated.getVazhvathramName());

                    existing.setRegionalVazhvathramName(
                            updated.getRegionalVazhvathramName());

                    existing.setFormationDate(
                            updated.getFormationDate());

                    existing.setQualityCheckedDate(
                            updated.getQualityCheckedDate());

                    existing.setMeetingType(
                            updated.getMeetingType());

                    existing.setMeetingDate(
                            updated.getMeetingDate());

                    existing.setFormedBy(
                            updated.getFormedBy());

                    existing.setVillageName(
                            updated.getVillageName());

                    existing.setBankName(
                            updated.getBankName());

                    existing.setBranchName(
                            updated.getBranchName());

                    existing.setServiceAreaBranch(
                            updated.getServiceAreaBranch());

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