package com.example.backend.controller;

import com.example.backend.entity.RequestEditTransaction;
import com.example.backend.repository.RequestEditTransactionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/request-edit-transactions")
@CrossOrigin(origins = "http://localhost:5173")
public class RequestEditTransactionController {

    private final RequestEditTransactionRepository repository;

    public RequestEditTransactionController(RequestEditTransactionRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<RequestEditTransaction> getByRequestedUpto(
            @RequestParam(required = false) String requestedUpto) {
        if (requestedUpto == null || requestedUpto.isBlank()) {
            return repository.findAll();
        }
        return repository.findByRequestedUpto(requestedUpto);
    }

    @GetMapping("/approved")
    public List<RequestEditTransaction> getApproved(
            @RequestParam(required = false) String requestedUpto) {
        if (requestedUpto == null || requestedUpto.isBlank()) {
            return repository.findAll().stream()
                    .filter(RequestEditTransaction::isApproved)
                    .toList();
        }
        return repository.findByRequestedUptoAndApproved(requestedUpto, true);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RequestEditTransaction> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public RequestEditTransaction create(@RequestBody RequestEditTransaction request) {
        return repository.save(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RequestEditTransaction> update(
            @PathVariable Long id,
            @RequestBody RequestEditTransaction request) {

        return repository.findById(id).map(existing -> {
            existing.setRequestedUpto(request.getRequestedUpto());
            existing.setGroupName(request.getGroupName());
            existing.setOption(request.getOption());
            existing.setApproved(request.isApproved());
            return ResponseEntity.ok(repository.save(existing));
        }).orElseGet(() -> ResponseEntity.notFound().build());
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

