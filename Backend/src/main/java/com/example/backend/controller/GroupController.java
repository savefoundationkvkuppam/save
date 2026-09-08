package com.example.backend.controller;

import com.example.backend.entity.Group;
import com.example.backend.repository.GroupRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/groups")
@CrossOrigin(origins = "*")
public class GroupController {

    private final GroupRepository repository;

    public GroupController(GroupRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Group createGroup(@RequestBody Group group) {
        return repository.save(group);
    }

    @GetMapping
    public List<Group> getAllGroups() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Group> getGroupById(@PathVariable Long id) {
        Optional<Group> group = repository.findById(id);

        return group
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Group> updateGroup(
            @PathVariable Long id,
            @RequestBody Group groupDetails) {

        Optional<Group> existingGroup = repository.findById(id);

        if (existingGroup.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Group group = existingGroup.get();

        group.setGroupCode(groupDetails.getGroupCode());
        group.setGroupName(groupDetails.getGroupName());
        group.setRegionalGroupName(groupDetails.getRegionalGroupName());
        group.setFormationDate(groupDetails.getFormationDate());

        return ResponseEntity.ok(repository.save(group));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroup(@PathVariable Long id) {

        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
