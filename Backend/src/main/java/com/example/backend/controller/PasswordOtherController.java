package com.example.backend.controller;

import com.example.backend.entity.PasswordOther;
import com.example.backend.repository.PasswordOtherRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/password-others")
@CrossOrigin(origins = "http://localhost:5173")
public class PasswordOtherController {

    private final PasswordOtherRepository repository;

    public PasswordOtherController(PasswordOtherRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<PasswordOther> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<PasswordOther> changePassword(@RequestBody PasswordRequest request) {
        if (request.password == null || request.password.length() < 8) {
            return ResponseEntity.badRequest().build();
        }

        PasswordOther item = new PasswordOther();
        item.setFedCode(request.fedCode);
        item.setInstType(request.instType);
        item.setUser(request.user);
        item.setPasswordHash(sha256(request.password));
        item.setChangedAt(LocalDateTime.now());

        return ResponseEntity.ok(repository.save(item));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private String sha256(String value) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] bytes = digest.digest(value.getBytes(StandardCharsets.UTF_8));

            StringBuilder result = new StringBuilder();
            for (byte b : bytes) {
                result.append(String.format("%02x", b));
            }
            return result.toString();
        } catch (Exception ex) {
            throw new IllegalStateException("Unable to hash password", ex);
        }
    }

    public static class PasswordRequest {
        public String fedCode;
        public String instType;
        public String user;
        public String password;
    }
}

