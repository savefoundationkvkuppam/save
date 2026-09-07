package com.example.backend.controller;

import com.example.backend.entity.AddUser;
import com.example.backend.repository.AddUserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.List;

@RestController
@RequestMapping("/api/add-users")
@CrossOrigin(origins = "http://localhost:5173")
public class AddUserController {

    private final AddUserRepository repository;

    public AddUserController(AddUserRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<AddUser> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<AddUser> create(@RequestBody AddUserRequest request) {
        if (request.password == null || request.password.length() < 8) {
            return ResponseEntity.badRequest().build();
        }

        AddUser item = new AddUser();
        item.setFedCode(request.fedCode);
        item.setUserCode(request.userCode);
        item.setName(request.name);
        item.setPasswordHash(sha256(request.password));
        item.setRole(request.role);
        item.setStatus(request.status);
        item.setCluster(request.cluster);

        return ResponseEntity.ok(repository.save(item));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddUser> update(
            @PathVariable Long id,
            @RequestBody AddUserRequest request) {

        return repository.findById(id).map(existing -> {
            existing.setFedCode(request.fedCode);
            existing.setUserCode(request.userCode);
            existing.setName(request.name);
            existing.setRole(request.role);
            existing.setStatus(request.status);
            existing.setCluster(request.cluster);

            if (request.password != null && !request.password.isBlank()) {
                existing.setPasswordHash(sha256(request.password));
            }

            return ResponseEntity.ok(repository.save(existing));
        }).orElse(ResponseEntity.notFound().build());
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

    public static class AddUserRequest {
        public String fedCode;
        public String userCode;
        public String name;
        public String password;
        public String role;
        public String status;
        public String cluster;
    }
}
