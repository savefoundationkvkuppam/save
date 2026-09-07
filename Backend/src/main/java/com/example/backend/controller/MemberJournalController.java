package com.example.backend.controller;

import com.example.backend.entity.MemberJournal;
import com.example.backend.repository.MemberJournalRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/member-journals")
public class MemberJournalController {
    private final MemberJournalRepository repository;

    public MemberJournalController(MemberJournalRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<MemberJournal> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberJournal> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public MemberJournal create(@RequestBody MemberJournal journal) {
        return repository.save(journal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberJournal> update(
            @PathVariable Long id,
            @RequestBody MemberJournal updated) {

        return repository.findById(id).map(existing -> {
            existing.setJrNo(updated.getJrNo());
            existing.setDate(updated.getDate());
            existing.setMember(updated.getMember());
            existing.setGenLedger(updated.getGenLedger());

            existing.setSubLed1(updated.getSubLed1()); existing.setType1(updated.getType1()); existing.setAmt1(updated.getAmt1());
            existing.setSubLed2(updated.getSubLed2()); existing.setType2(updated.getType2()); existing.setAmt2(updated.getAmt2());
            existing.setSubLed3(updated.getSubLed3()); existing.setType3(updated.getType3()); existing.setAmt3(updated.getAmt3());
            existing.setSubLed4(updated.getSubLed4()); existing.setType4(updated.getType4()); existing.setAmt4(updated.getAmt4());
            existing.setSubLed5(updated.getSubLed5()); existing.setType5(updated.getType5()); existing.setAmt5(updated.getAmt5());
            existing.setSubLed6(updated.getSubLed6()); existing.setType6(updated.getType6()); existing.setAmt6(updated.getAmt6());

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
