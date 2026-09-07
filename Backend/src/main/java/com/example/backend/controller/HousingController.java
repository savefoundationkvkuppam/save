package com.example.backend.controller;

import com.example.backend.entity.Housing;
import com.example.backend.repository.HousingRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/housings")
@CrossOrigin(origins = "*")
public class HousingController {

    private final HousingRepository repository;

    public HousingController(HousingRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Housing> getAll() { return repository.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Housing> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/member/{memberId}")
    public List<Housing> getByMemberId(@PathVariable Long memberId) {
        return repository.findByMemberId(memberId);
    }

    @PostMapping
    public Housing create(@RequestBody Housing housing) {
        return repository.save(housing);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Housing> update(@PathVariable Long id, @RequestBody Housing updated) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setMemberId(updated.getMemberId());
                    existing.setMemberName(updated.getMemberName());
                    existing.setTypeOfHouse(updated.getTypeOfHouse());
                    existing.setOwnership(updated.getOwnership());
                    existing.setRentAmount(updated.getRentAmount());
                    existing.setRentAdvance(updated.getRentAdvance());
                    existing.setLeaseAmount(updated.getLeaseAmount());
                    existing.setConstructionYear(updated.getConstructionYear());
                    existing.setHouseValue(updated.getHouseValue());
                    existing.setHousePattaName(updated.getHousePattaName());
                    existing.setToiletFacility(updated.getToiletFacility());
                    existing.setToiletFacilitySpace(updated.getToiletFacilitySpace());
                    existing.setUsageOfToilet(updated.getUsageOfToilet());
                    existing.setUndergroundDrainage(updated.getUndergroundDrainage());
                    existing.setElectricity(updated.getElectricity());
                    existing.setTapWaterConnection(updated.getTapWaterConnection());
                    existing.setDrinkingWaterSource(updated.getDrinkingWaterSource());
                    existing.setWaterFilter(updated.getWaterFilter());
                    existing.setRoofWaterHarvesting(updated.getRoofWaterHarvesting());
                    existing.setKitchenGardenSpace(updated.getKitchenGardenSpace());
                    existing.setHousePlotPatta(updated.getHousePlotPatta());
                    existing.setHousePlotArea(updated.getHousePlotArea());
                    existing.setPlotValue(updated.getPlotValue());
                    existing.setPlotPattaName(updated.getPlotPattaName());
                    return ResponseEntity.ok(repository.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repository.existsById(id)) return ResponseEntity.notFound().build();
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

