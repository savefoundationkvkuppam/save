package com.example.backend.controller;

import com.example.backend.entity.MapDig;
import com.example.backend.repository.MapDigRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/map-dig")
public class MapDigController {

    private final MapDigRepository repository;

    public MapDigController(MapDigRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<MapDig> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MapDig> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public MapDig create(@RequestBody MapDig mapDig) {
        return repository.save(mapDig);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MapDig> update(
            @PathVariable Long id,
            @RequestBody MapDig updated) {

        return repository.findById(id)
                .map(existing -> {
                    existing.setStaffName(updated.getStaffName());
                    existing.setGroupName(updated.getGroupName());
                    existing.setPrimaryReason(updated.getPrimaryReason());
                    existing.setSecondaryReason(updated.getSecondaryReason());
                    existing.setTertiaryReason(updated.getTertiaryReason());
                    existing.setQuaternaryReason(updated.getQuaternaryReason());
                    existing.setQuinaryReason(updated.getQuinaryReason());
                    existing.setOtherReason(updated.getOtherReason());
                    existing.setSelected(updated.isSelected());

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
