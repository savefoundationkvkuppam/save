package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "other_journals")
public class OtherJournal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String journalNumber;
    private String journalDate;
    private String generalLedger;
    private String subLedgerMain;
    private String debitCredit;
    private String amountMain;
    private String amountMode;

    @Column(columnDefinition = "TEXT")
    private String rowsJson;

    @Column(columnDefinition = "TEXT")
    private String narration;

    private String creditTotal;
    private String debitTotal;

    public OtherJournal() {}

    public Long getId() { return id; }
    public String getJournalNumber() { return journalNumber; }
    public void setJournalNumber(String v) { journalNumber = v; }
    public String getJournalDate() { return journalDate; }
    public void setJournalDate(String v) { journalDate = v; }
    public String getGeneralLedger() { return generalLedger; }
    public void setGeneralLedger(String v) { generalLedger = v; }
    public String getSubLedgerMain() { return subLedgerMain; }
    public void setSubLedgerMain(String v) { subLedgerMain = v; }
    public String getDebitCredit() { return debitCredit; }
    public void setDebitCredit(String v) { debitCredit = v; }
    public String getAmountMain() { return amountMain; }
    public void setAmountMain(String v) { amountMain = v; }
    public String getAmountMode() { return amountMode; }
    public void setAmountMode(String v) { amountMode = v; }
    public String getRowsJson() { return rowsJson; }
    public void setRowsJson(String v) { rowsJson = v; }
    public String getNarration() { return narration; }
    public void setNarration(String v) { narration = v; }
    public String getCreditTotal() { return creditTotal; }
    public void setCreditTotal(String v) { creditTotal = v; }
    public String getDebitTotal() { return debitTotal; }
    public void setDebitTotal(String v) { debitTotal = v; }
}
