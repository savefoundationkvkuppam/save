package com.example.backend.controller;

import com.example.backend.entity.Member;
import com.example.backend.repository.MemberRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberRepository repository;

    public MemberController(MemberRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Member> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Member create(@RequestBody Member member) {
        return repository.save(member);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Member> update(
            @PathVariable Long id,
            @RequestBody Member updated) {

        return repository.findById(id)
                .map(existing -> {

                    existing.setMemberCode(updated.getMemberCode());
                    existing.setMemberName(updated.getMemberName());

                    existing.setRegionalMemberName(
                            updated.getRegionalMemberName());
                    existing.setClusterName(
                        updated.getClusterName());
                    existing.setVazhvathramName(
                        updated.getVazhvathramName());

                    existing.setDesignation(updated.getDesignation());

                    existing.setDate(updated.getDate());

                    existing.setDateOfJoining(
                            updated.getDateOfJoining());

                    existing.setYearOfBirth(
                            updated.getYearOfBirth());

                    existing.setMaritalStatus(
                            updated.getMaritalStatus());

                    existing.setHusbandFatherName(
                            updated.getHusbandFatherName());

                    existing.setAliveStatus(
                            updated.getAliveStatus());

                    existing.setCategory(
                            updated.getCategory());

                    existing.setFamilyCategory(
                            updated.getFamilyCategory());

                    existing.setCaste(
                            updated.getCaste());

                    existing.setRationCard(
                            updated.getRationCard());

                    existing.setRationCardNo(
                            updated.getRationCardNo());

                    existing.setVoterId(
                            updated.getVoterId());

                    existing.setSpouseVoterId(
                            updated.getSpouseVoterId());

                    existing.setAadharId(
                            updated.getAadharId());

                    existing.setSpouseAadharId(
                            updated.getSpouseAadharId());

                    existing.setMobileNumber(
                            updated.getMobileNumber());

                    existing.setSpouseMobileNumber(
                            updated.getSpouseMobileNumber());

                    existing.setJobCardNo(
                            updated.getJobCardNo());

                    existing.setPanCardNo(
                            updated.getPanCardNo());

                    existing.setRegularSavings(
                            updated.getRegularSavings());

                    existing.setSpecialSavings(
                            updated.getSpecialSavings());

                    // Mem.House Det
                    existing.setHouseOwnership(
                            updated.getHouseOwnership());

                    // Unlock Members
                    existing.setLocked(
                            updated.isLocked());

                    return ResponseEntity.ok(
                            repository.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/code/{memberCode}")
    public ResponseEntity<Void> deleteByMemberCode(
            @PathVariable String memberCode) {

        return repository.findByMemberCode(memberCode)
                .map(member -> {
                    repository.delete(member);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
