package com.example.backend.controller;

import com.example.backend.entity.DigMeeting;
import com.example.backend.repository.DigMeetingRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dig-meeting")
public class DigMeetingController {

    private final DigMeetingRepository repository;

    public DigMeetingController(DigMeetingRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<DigMeeting> getAll(@RequestParam(required = false) String month) {
        if (month != null && !month.isBlank()) {
            return repository.findByMeetingMonth(month);
        }
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DigMeeting> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public DigMeeting create(@RequestBody DigMeeting digMeeting) {
        return repository.save(digMeeting);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DigMeeting> update(
            @PathVariable Long id,
            @RequestBody DigMeeting updated) {

        return repository.findById(id)
                .map(existing -> {
                    existing.setMeetingMonth(updated.getMeetingMonth());
                    existing.setDigGroupName(updated.getDigGroupName());
                    existing.setStatus(updated.getStatus());
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

