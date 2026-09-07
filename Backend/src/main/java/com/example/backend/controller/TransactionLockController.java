package com.example.backend.controller;

import com.example.backend.entity.TransactionLock;
import com.example.backend.repository.TransactionLockRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/transaction-locks")
public class TransactionLockController {
    private final TransactionLockRepository repository;

    public TransactionLockController(TransactionLockRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/status")
    public ResponseEntity<TransactionLock> getStatus(
            @RequestParam String vazhvathramCode,
            @RequestParam String month) {
        return repository.findTopByVazhvathramCodeAndMonthOrderByIdDesc(vazhvathramCode, month)
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

        TransactionLock lock = repository
                .findTopByVazhvathramCodeAndMonthOrderByIdDesc(request.vazhvathramCode, request.month)
                .orElseGet(TransactionLock::new);

        lock.setVazhvathramCode(request.vazhvathramCode.trim());
        lock.setMonth(request.month.trim());
        lock.setAttendanceDate(request.attendanceDate);
        lock.setReceiptDate(request.receiptDate);
        lock.setPasswordHash(sha256(request.password));
        lock.setLocked(true);
        lock.setLockedAt(LocalDateTime.now());

        return ResponseEntity.ok(repository.save(lock));
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
        public String attendanceDate;
        public String receiptDate;
    }
}
