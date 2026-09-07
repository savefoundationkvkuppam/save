package com.example.backend.controller;

import com.example.backend.entity.Attendance;
import com.example.backend.repository.AttendanceRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendances")
@CrossOrigin(origins = "http://localhost:5173")
public class AttendanceController {
    private final AttendanceRepository repository;

    public AttendanceController(AttendanceRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Attendance> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Attendance create(@RequestBody Attendance attendance) {
        return repository.save(attendance);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Attendance> update(@PathVariable Long id, @RequestBody Attendance details) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setMeetingDate(details.getMeetingDate());
                    existing.setRvColDate(details.getRvColDate());
                    existing.setReason(details.getReason());
                    existing.setOtherReason(details.getOtherReason());
                    existing.setNotConducted(details.isNotConducted());
                    existing.setSpecialMeeting(details.isSpecialMeeting());
                    existing.setAttendedMembers(details.getAttendedMembers());
                    return ResponseEntity.ok(repository.save(existing));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
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

