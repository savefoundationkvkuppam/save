package com.example.backend.controller;

import com.example.backend.entity.StaffDetail;
import com.example.backend.repository.StaffDetailRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/staff-details")
@CrossOrigin(origins = "*")
public class StaffDetailController {
    private final StaffDetailRepository repository;

    public StaffDetailController(StaffDetailRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<StaffDetail> getAll() { return repository.findAll(); }

    @PostMapping
    public StaffDetail create(@RequestBody StaffDetail staff) { return repository.save(staff); }

    @PutMapping("/{id}")
    public ResponseEntity<StaffDetail> update(@PathVariable Long id, @RequestBody StaffDetail details) {
        return repository.findById(id).map(existing -> {
            existing.setFedCode(details.getFedCode());
            existing.setCode(details.getCode());
            existing.setStaffName(details.getStaffName());
            existing.setMlLeaveCode(details.getMlLeaveCode());
            existing.setRole(details.getRole());
            existing.setDhanFedStaff(details.getDhanFedStaff());
            return ResponseEntity.ok(repository.save(existing));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repository.existsById(id)) return ResponseEntity.notFound().build();
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
