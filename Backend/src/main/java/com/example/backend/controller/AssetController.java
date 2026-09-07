package com.example.backend.controller;

import com.example.backend.entity.Asset;
import com.example.backend.repository.AssetRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assets")
public class AssetController {
    private final AssetRepository repository;

    public AssetController(AssetRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Asset> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asset> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/member/{memberId}")
    public List<Asset> getByMember(@PathVariable Long memberId) {
        return repository.findByMemberId(memberId);
    }

    @PostMapping
    public Asset create(@RequestBody Asset asset) {
        return repository.save(asset);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Asset> update(@PathVariable Long id, @RequestBody Asset updated) {
        return repository.findById(id).map(existing -> {
            existing.setMemberId(updated.getMemberId());
            existing.setMemberName(updated.getMemberName());
            existing.setAsset(updated.getAsset());
            existing.setQuantity(updated.getQuantity());
            existing.setPurchaseYear(updated.getPurchaseYear());
            existing.setValue(updated.getValue());
            existing.setInsurance(updated.getInsurance());
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
}
