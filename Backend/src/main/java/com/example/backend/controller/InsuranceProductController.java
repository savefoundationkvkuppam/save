package com.example.backend.controller;

import com.example.backend.entity.InsuranceProduct;
import com.example.backend.repository.InsuranceProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/insurance-products")
@CrossOrigin(origins = "http://localhost:5173")
public class InsuranceProductController {

    private final InsuranceProductRepository repository;

    public InsuranceProductController(InsuranceProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<InsuranceProduct> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InsuranceProduct> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public InsuranceProduct create(@RequestBody InsuranceProduct item) {
        return repository.save(item);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InsuranceProduct> update(
            @PathVariable Long id,
            @RequestBody InsuranceProduct updated) {

        return repository.findById(id).map(existing -> {

            existing.setFederationCode(updated.getFederationCode());
            existing.setOgiLifeMember(updated.getOgiLifeMember());
            existing.setPmLifeMember(updated.getPmLifeMember());
            existing.setNalam(updated.getNalam());
            existing.setPmHealth(updated.getPmHealth());
            existing.setOgiLifeSpouse(updated.getOgiLifeSpouse());
            existing.setPmLifeSpouse(updated.getPmLifeSpouse());
            existing.setPmCow(updated.getPmCow());
            existing.setPmGoat(updated.getPmGoat());
            existing.setTataAiaMember(updated.getTataAiaMember());
            existing.setTataAiaSpouse(updated.getTataAiaSpouse());
            existing.setPmLifeOldAgeMember(
                    updated.getPmLifeOldAgeMember()
            );
            existing.setPmLifeOldAgeSpouse(
                    updated.getPmLifeOldAgeSpouse()
            );
            existing.setDateChange(updated.getDateChange());

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