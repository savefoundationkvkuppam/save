package com.example.backend.controller;

import com.example.backend.entity.GeneralLedger;
import com.example.backend.repository.GeneralLedgerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/general-ledgers")
@CrossOrigin
public class GeneralLedgerController {

    private final GeneralLedgerRepository repository;

    public GeneralLedgerController(
            GeneralLedgerRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<GeneralLedger> getAll() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GeneralLedger create(@RequestBody GeneralLedger ledger) {
        if (ledger.getGlCode() == null ||
                ledger.getGlCode().isBlank()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "GL Code is required");
        }

        if (ledger.getGlName() == null ||
                ledger.getGlName().isBlank()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "GL Name is required");
        }

        if (repository.existsByGlCode(ledger.getGlCode())) {
            throw new ResponseStatusException(
                HttpStatus.CONFLICT, "GL Code already exists");
        }

        return repository.save(ledger);
    }
}
