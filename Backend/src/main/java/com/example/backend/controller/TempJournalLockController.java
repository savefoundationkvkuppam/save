package com.example.backend.controller;

import com.example.backend.entity.TempJournalLock;
import com.example.backend.repository.TempJournalLockRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/temp-journal-locks")
@CrossOrigin(origins = "http://localhost:5173")
public class TempJournalLockController {
    private final TempJournalLockRepository repository;

    public TempJournalLockController(TempJournalLockRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/status")
    public ResponseEntity<TempJournalLock> getStatus(
            @RequestParam String vazhvathramCode,
            @RequestParam String month) {
        return repository.findTopByVazhvathramCodeAndMonthOrderByIdDesc(vazhvathramCode, month)
                .filter(TempJournalLock::isLocked)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/lock")
    public ResponseEntity<?> lock(@RequestBody LockRequest request) {
        if (isBlank(request.vazhvathramCode) || isBlank(request.month)) {
            return ResponseEntity.badRequest().body("Vazhvathram Code and Month are required");
        }
        if (isBlank(request.password)) {
            return ResponseEntity.badRequest().body("Please enter password");
        }

        TempJournalLock lock = repository
                .findTopByVazhvathramCodeAndMonthOrderByIdDesc(request.vazhvathramCode, request.month)
                .orElseGet(TempJournalLock::new);

        lock.setVazhvathramCode(request.vazhvathramCode.trim());
        lock.setMonth(request.month.trim());
        lock.setPasswordHash(sha256(request.password));
        lock.setLocked(true);
        lock.setLockedAt(LocalDateTime.now());

        return ResponseEntity.ok(repository.save(lock));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id, @RequestBody(required = false) DeleteRequest request) {
        return repository.findById(id).map(lock -> {
            if (request == null || isBlank(request.password)) {
                return ResponseEntity.badRequest().body("Please enter password");
            }
            if (!sha256(request.password).equals(lock.getPasswordHash())) {
                return ResponseEntity.status(401).body("Incorrect password");
            }
            repository.delete(lock);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }

    private static boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

    private static String sha256(String value) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(value.getBytes(StandardCharsets.UTF_8));
            StringBuilder result = new StringBuilder();
            for (byte b : hash) result.append(String.format("%02x", b));
            return result.toString();
        } catch (Exception e) {
            throw new IllegalStateException("Unable to secure password", e);
        }
    }

    public static class LockRequest {
        public String vazhvathramCode;
        public String month;
        public String password;
    }

    public static class DeleteRequest {
        public String password;
    }
}
