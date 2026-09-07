package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "clusters")
public class Cluster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cluster_code", nullable = false)
    private String clusterCode;

    @Column(name = "cluster_name", nullable = false)
    private String clusterName;

    @Column(name = "regional_cluster_name")
    private String regionalClusterName;

    @Column(name = "formation_date")
    private String formationDate;

    // Default constructor required by JPA
    public Cluster() {
    }

    // Get ID
    public Long getId() {
        return id;
    }

    // Cluster Code
    public String getClusterCode() {
        return clusterCode;
    }

    public void setClusterCode(String clusterCode) {
        this.clusterCode = clusterCode;
    }

    // Cluster Name
    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    // Regional Cluster Name
    public String getRegionalClusterName() {
        return regionalClusterName;
    }

    public void setRegionalClusterName(String regionalClusterName) {
        this.regionalClusterName = regionalClusterName;
    }

    // Formation Date
    public String getFormationDate() {
        return formationDate;
    }

    public void setFormationDate(String formationDate) {
        this.formationDate = formationDate;
    }
}