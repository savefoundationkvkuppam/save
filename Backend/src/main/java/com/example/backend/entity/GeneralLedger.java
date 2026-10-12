package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(
    name = "general_ledger_master",
    uniqueConstraints = @UniqueConstraint(
        columnNames = "gl_code"
    )
)
public class GeneralLedger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "gl_code", nullable = false, unique = true)
    private String glCode;

    @Column(name = "gl_name", nullable = false)
    private String glName;

    private String subLedger;
    private String glType;
    private String relatedTo;
    private String regionalGlName;

    public Long getId() { return id; }
    public String getGlCode() { return glCode; }
    public void setGlCode(String glCode) { this.glCode = glCode; }

    public String getGlName() { return glName; }
    public void setGlName(String glName) { this.glName = glName; }

    public String getSubLedger() { return subLedger; }
    public void setSubLedger(String subLedger) {
        this.subLedger = subLedger;
    }

    public String getGlType() { return glType; }
    public void setGlType(String glType) { this.glType = glType; }

    public String getRelatedTo() { return relatedTo; }
    public void setRelatedTo(String relatedTo) {
        this.relatedTo = relatedTo;
    }

    public String getRegionalGlName() { return regionalGlName; }
    public void setRegionalGlName(String regionalGlName) {
        this.regionalGlName = regionalGlName;
    }
}
