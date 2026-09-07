package com.example.backend.controller;

import com.example.backend.entity.DataEntryExtensionRequest;
import com.example.backend.repository.DataEntryExtensionRequestRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/data-entry-extension")
public class DataEntryExtensionRequestController {

    private final DataEntryExtensionRequestRepository repository;

    public DataEntryExtensionRequestController(
            DataEntryExtensionRequestRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<DataEntryExtensionRequest> getAll(
            @RequestParam(required = false) String requestedUpto) {

        if (requestedUpto != null && !requestedUpto.isBlank()) {
            return repository.findByRequestedUptoOrderByIdAsc(requestedUpto);
        }

        return repository.findAll();
    }

    @GetMapping("/approved")
    public List<DataEntryExtensionRequest> getApproved(
            @RequestParam String requestedUpto) {

        return repository.findByRequestedUptoAndApprovedOrderByIdAsc(
                requestedUpto,
                true
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataEntryExtensionRequest> getById(
            @PathVariable Long id) {

        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public DataEntryExtensionRequest create(
            @RequestBody DataEntryExtensionRequest request) {

        return repository.save(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataEntryExtensionRequest> update(
            @PathVariable Long id,
            @RequestBody DataEntryExtensionRequest updated) {

        return repository.findById(id)
                .map(existing -> {
                    existing.setRequestedUpto(updated.getRequestedUpto());
                    existing.setGroupName(updated.getGroupName());
                    existing.setOption(updated.getOption());
                    existing.setApproved(updated.isApproved());

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

