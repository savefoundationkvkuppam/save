package com.example.backend.controller;

import com.example.backend.entity.ChangeMeetingDate;
import com.example.backend.repository.ChangeMeetingDateRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/change-meeting-date")
@CrossOrigin(origins = "*")
public class ChangeMeetingDateController {

    private final ChangeMeetingDateRepository repository;

    public ChangeMeetingDateController(
            ChangeMeetingDateRepository repository) {
        this.repository = repository;
    }

    // List all records for a particular change date
    @GetMapping
    public List<ChangeMeetingDate> getByChangeDate(
            @RequestParam(required = false) String changeDate) {

        if (changeDate == null || changeDate.trim().isEmpty()) {
            return repository.findAll();
        }

        return repository.findByChangeDate(changeDate);
    }

    // List only approved groups
    @GetMapping("/approved")
    public List<ChangeMeetingDate> getApproved(
            @RequestParam(required = false) String changeDate) {

        if (changeDate == null || changeDate.trim().isEmpty()) {
            return repository.findAll()
                    .stream()
                    .filter(ChangeMeetingDate::isApproved)
                    .toList();
        }

        return repository.findByChangeDateAndApproved(
                changeDate,
                true
        );
    }

    // Get one record
    @GetMapping("/{id}")
    public ResponseEntity<ChangeMeetingDate> getById(
            @PathVariable Long id) {

        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Save new record
    @PostMapping
    public ChangeMeetingDate create(
            @RequestBody ChangeMeetingDate data) {

        return repository.save(data);
    }

    // Update existing record
    @PutMapping("/{id}")
    public ResponseEntity<ChangeMeetingDate> update(
            @PathVariable Long id,
            @RequestBody ChangeMeetingDate updatedData) {

        return repository.findById(id)
                .map(existing -> {

                    existing.setChangeDate(
                            updatedData.getChangeDate()
                    );

                    existing.setGroupName(
                            updatedData.getGroupName()
                    );

                    existing.setMeetingDate(
                            updatedData.getMeetingDate()
                    );

                    existing.setApproved(
                            updatedData.isApproved()
                    );

                    return ResponseEntity.ok(
                            repository.save(existing)
                    );
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete record
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
