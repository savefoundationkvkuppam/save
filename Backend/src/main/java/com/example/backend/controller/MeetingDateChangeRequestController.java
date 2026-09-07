package com.example.backend.controller;

import com.example.backend.entity.MeetingDateChangeRequest;
import com.example.backend.repository.MeetingDateChangeRequestRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meeting-date-change")
public class MeetingDateChangeRequestController {

    private final MeetingDateChangeRequestRepository repository;

    public MeetingDateChangeRequestController(
            MeetingDateChangeRequestRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<MeetingDateChangeRequest> getAll(
            @RequestParam(required = false) String requestedDate) {

        if (requestedDate != null && !requestedDate.isBlank()) {
            return repository.findByRequestedDateOrderByIdAsc(requestedDate);
        }

        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MeetingDateChangeRequest> getById(
            @PathVariable Long id) {

        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public MeetingDateChangeRequest create(
            @RequestBody MeetingDateChangeRequest request) {

        return repository.save(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MeetingDateChangeRequest> update(
            @PathVariable Long id,
            @RequestBody MeetingDateChangeRequest updated) {

        return repository.findById(id)
                .map(existing -> {
                    existing.setRequestedDate(updated.getRequestedDate());
                    existing.setGroupName(updated.getGroupName());
                    existing.setOption(updated.getOption());

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
