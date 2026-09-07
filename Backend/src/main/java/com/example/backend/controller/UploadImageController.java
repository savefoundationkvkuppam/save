package com.example.backend.controller;

import com.example.backend.entity.UploadImage;
import com.example.backend.repository.UploadImageRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/upload-images")
public class UploadImageController {

    private final UploadImageRepository repository;

    public UploadImageController(UploadImageRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<UploadImage> getAll() {
        return repository.findAll();
    }

    @GetMapping("/type/{documentType}")
    public List<UploadImage> getByDocumentType(@PathVariable String documentType) {
        return repository.findByDocumentType(documentType);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UploadImage> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public UploadImage create(@RequestBody UploadImage uploadImage) {
        return repository.save(uploadImage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UploadImage> update(
            @PathVariable Long id,
            @RequestBody UploadImage updated) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setDocumentType(updated.getDocumentType());
                    existing.setMemberCode(updated.getMemberCode());
                    existing.setMemberName(updated.getMemberName());
                    existing.setDocumentNo(updated.getDocumentNo());
                    existing.setFileName(updated.getFileName());
                    existing.setSavedAt(updated.getSavedAt());
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
