package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "bank_loan_not_needed")
public class BankLoanNotNeeded {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vazhvathram;
    private boolean dontNeedBkLn;
    private String reason;

    public BankLoanNotNeeded() {
    }

    public Long getId() {
        return id;
    }

    public String getVazhvathram() {
        return vazhvathram;
    }

    public void setVazhvathram(String vazhvathram) {
        this.vazhvathram = vazhvathram;
    }

    public boolean isDontNeedBkLn() {
        return dontNeedBkLn;
    }

    public void setDontNeedBkLn(boolean dontNeedBkLn) {
        this.dontNeedBkLn = dontNeedBkLn;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}

