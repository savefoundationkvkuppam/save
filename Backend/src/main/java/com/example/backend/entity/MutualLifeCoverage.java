package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "mutual_life_coverages")
public class MutualLifeCoverage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String batchNumber;

    private String policyReceivedDate;

    private String masterPolicyNumber;

    private String coverageStartingDate;

    private String coverageEndingDate;

    public MutualLifeCoverage() {
    }

    public Long getId() { return id; }

    public String getBatchNumber() { return batchNumber; }
    public void setBatchNumber(String batchNumber) { this.batchNumber = batchNumber; }

    public String getPolicyReceivedDate() { return policyReceivedDate; }
    public void setPolicyReceivedDate(String policyReceivedDate) { this.policyReceivedDate = policyReceivedDate; }

    public String getMasterPolicyNumber() { return masterPolicyNumber; }
    public void setMasterPolicyNumber(String masterPolicyNumber) { this.masterPolicyNumber = masterPolicyNumber; }

    public String getCoverageStartingDate() { return coverageStartingDate; }
    public void setCoverageStartingDate(String coverageStartingDate) { this.coverageStartingDate = coverageStartingDate; }

    public String getCoverageEndingDate() { return coverageEndingDate; }
    public void setCoverageEndingDate(String coverageEndingDate) { this.coverageEndingDate = coverageEndingDate; }

}

