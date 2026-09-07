package com.example.backend.controller;

import com.example.backend.entity.Land;
import com.example.backend.repository.LandRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lands")
public class LandController {

    private final LandRepository repository;

    public LandController(LandRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Land> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Land> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/member/{memberId}")
    public List<Land> getByMemberId(@PathVariable Long memberId) {
        return repository.findByMemberId(memberId);
    }

    @PostMapping
    public Land create(@RequestBody Land land) {
        return repository.save(land);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Land> update(@PathVariable Long id, @RequestBody Land updated) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setMemberId(updated.getMemberId());
                    existing.setMemberName(updated.getMemberName());
                    existing.setLandOwnership(updated.getLandOwnership());
                    existing.setAreaInAcre(updated.getAreaInAcre());
                    existing.setLandValue(updated.getLandValue());
                    existing.setLandPatta(updated.getLandPatta());
                    existing.setLandName(updated.getLandName());
                    existing.setIrrigationType(updated.getIrrigationType());
                    existing.setCrop1(updated.getCrop1());
                    existing.setCrop2(updated.getCrop2());
                    existing.setYieldCrop1(updated.getYieldCrop1());
                    existing.setYieldCrop2(updated.getYieldCrop2());
                    existing.setMarketPlace(updated.getMarketPlace());
                    existing.setCropInsurance(updated.getCropInsurance());
                    existing.setAnnualValue(updated.getAnnualValue());
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

