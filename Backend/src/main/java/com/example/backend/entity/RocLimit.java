package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "roc_limits")
public class RocLimit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vazhvathramName;

    private String rocLimitDate;

    private String bankRoc;

    private String kdfsRoc;

    public RocLimit() {
    }

    public Long getId() {
        return id;
    }

    public String getVazhvathramName() {
        return vazhvathramName;
    }

    public void setVazhvathramName(String vazhvathramName) {
        this.vazhvathramName = vazhvathramName;
    }

    public String getRocLimitDate() {
        return rocLimitDate;
    }

    public void setRocLimitDate(String rocLimitDate) {
        this.rocLimitDate = rocLimitDate;
    }

    public String getBankRoc() {
        return bankRoc;
    }

    public void setBankRoc(String bankRoc) {
        this.bankRoc = bankRoc;
    }

    public String getKdfsRoc() {
        return kdfsRoc;
    }

    public void setKdfsRoc(String kdfsRoc) {
        this.kdfsRoc = kdfsRoc;
    }
}