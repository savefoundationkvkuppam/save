package com.example.backend.controller;

import com.example.backend.entity.AutoJournalLock;
import com.example.backend.repository.AutoJournalLockRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/auto-journal-locks")
@CrossOrigin(origins = "http://localhost:5173")
public class AutoJournalLockController {
    private final AutoJournalLockRepository repository;

    public AutoJournalLockController(AutoJournalLockRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<AutoJournalLock> getAll() {
        return repository.findAll();
    }

    @GetMapping("/status")
    public ResponseEntity<AutoJournalLock> getStatus(
            @RequestParam String vazhvathramCode,
            @RequestParam String month) {
        return repository.findByVazhvathramCodeAndMonth(vazhvathramCode, month)
                .filter(AutoJournalLock::isLocked)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/lock")
    public ResponseEntity<?> lock(@RequestBody Map<String, String> request) {
        String code = request.get("vazhvathramCode");
        String month = request.get("month");
        String password = request.get("password");

        if (isBlank(code) || isBlank(month) || isBlank(password)) {
            return ResponseEntity.badRequest().body(Map.of("error", "Vazhvathram code, month and password are required"));
        }

        AutoJournalLock lock = repository.findByVazhvathramCodeAndMonth(code, month)
                .orElseGet(AutoJournalLock::new);

        lock.setVazhvathramCode(code);
        lock.setMonth(month);
        lock.setPasswordHash(sha256(password));
        lock.setLocked(true);

        return ResponseEntity.ok(repository.save(lock));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(
            @PathVariable Long id,
            @RequestBody(required = false) Map<String, String> request) {

        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        AutoJournalLock lock = repository.findById(id).orElseThrow();
        String password = request == null ? null : request.get("password");

        if (isBlank(password) || !sha256(password).equals(lock.getPasswordHash())) {
            return ResponseEntity.status(401).body(Map.of("error", "Invalid password"));
        }

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

    private String sha256(String value) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(value.getBytes(StandardCharsets.UTF_8));
            StringBuilder result = new StringBuilder();
            for (byte b : hash) {
                result.append(String.format("%02x", b));
            }
            return result.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-256 is not available", e);
        }
    }
}
