package com.example.backend.controller;

import com.example.backend.entity.LoginDetails;
import com.example.backend.repository.LoginDetailsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/login-details")
@CrossOrigin(origins = "*")
public class LoginDetailsController {

    private final LoginDetailsRepository repository;

    public LoginDetailsController(LoginDetailsRepository repository) {
        this.repository = repository;
    }

    // Get all login details
    @GetMapping
    public List<LoginDetails> getAllLoginDetails() {
        return repository.findAll();
    }

    // Save login details
    @PostMapping
    public LoginDetails saveLoginDetails(@RequestBody LoginDetails loginDetails) {
        return repository.save(loginDetails);
    }

    // Login API
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        Optional<LoginDetails> user =
                repository.findByUserIdAndPassword(
                        request.getUserId(),
                        request.getPassword()
                );

        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        }

        return ResponseEntity.status(401)
                .body("Invalid UserID or Password");
    }

    public static class LoginRequest {

        private String userId;
        private String password;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}