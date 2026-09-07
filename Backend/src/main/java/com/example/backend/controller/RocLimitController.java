package com.example.backend.controller;

import com.example.backend.entity.RocLimit;
import com.example.backend.repository.RocLimitRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roc-limits")
public class RocLimitController {

    private final RocLimitRepository repository;

    public RocLimitController(RocLimitRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<RocLimit> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RocLimit> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public RocLimit create(@RequestBody RocLimit rocLimit) {
        return repository.save(rocLimit);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RocLimit> update(
            @PathVariable Long id,
            @RequestBody RocLimit updated) {

        return repository.findById(id)
                .map(existing -> {

                    existing.setVazhvathramName(
                            updated.getVazhvathramName()
                    );

                    existing.setRocLimitDate(
                            updated.getRocLimitDate()
                    );

                    existing.setBankRoc(
                            updated.getBankRoc()
                    );

                    existing.setKdfsRoc(
                            updated.getKdfsRoc()
                    );

                    return ResponseEntity.ok(
                            repository.save(existing)
                    );
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
