package com.example.backend.controller;

import com.example.backend.entity.Cluster;
import com.example.backend.repository.ClusterRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clusters")
@CrossOrigin(origins = "http://localhost:5173")
public class ClusterController {

    private final ClusterRepository clusterRepository;

    public ClusterController(ClusterRepository clusterRepository) {
        this.clusterRepository = clusterRepository;
    }

    @PostMapping
    public Cluster createCluster(@RequestBody Cluster cluster) {
        return clusterRepository.save(cluster);
    }

    @GetMapping
    public List<Cluster> getAllClusters() {
        return clusterRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cluster> getClusterById(@PathVariable Long id) {
        return clusterRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cluster> updateCluster(
            @PathVariable Long id,
            @RequestBody Cluster updatedCluster) {

        return clusterRepository.findById(id)
                .map(existing -> {
                    existing.setClusterCode(updatedCluster.getClusterCode());
                    existing.setClusterName(updatedCluster.getClusterName());
                    existing.setRegionalClusterName(
                            updatedCluster.getRegionalClusterName()
                    );
                    existing.setFormationDate(
                            updatedCluster.getFormationDate()
                    );

                    return ResponseEntity.ok(
                            clusterRepository.save(existing)
                    );
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCluster(@PathVariable Long id) {

        if (!clusterRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        clusterRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}