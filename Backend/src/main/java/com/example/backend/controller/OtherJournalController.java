package com.example.backend.controller;

import com.example.backend.entity.OtherJournal;
import com.example.backend.repository.OtherJournalRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/other-journals")
@CrossOrigin(origins = "http://localhost:5173")
public class OtherJournalController {

    private final OtherJournalRepository repository;

    public OtherJournalController(OtherJournalRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<OtherJournal> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OtherJournal> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public OtherJournal create(@RequestBody OtherJournal journal) {
        return repository.save(journal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OtherJournal> update(
            @PathVariable Long id,
            @RequestBody OtherJournal updated) {

        return repository.findById(id).map(existing -> {

            existing.setJournalNumber(updated.getJournalNumber());
            existing.setJournalDate(updated.getJournalDate());
            existing.setGeneralLedger(updated.getGeneralLedger());
            existing.setSubLedgerMain(updated.getSubLedgerMain());
            existing.setDebitCredit(updated.getDebitCredit());
            existing.setAmountMain(updated.getAmountMain());
            existing.setAmountMode(updated.getAmountMode());
            existing.setRowsJson(updated.getRowsJson());
            existing.setNarration(updated.getNarration());
            existing.setCreditTotal(updated.getCreditTotal());
            existing.setDebitTotal(updated.getDebitTotal());

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