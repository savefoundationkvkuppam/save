package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "other_receipts")
public class OtherReceipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String receiptNo;
    private String receiptDate;
    private String receiptType;
    private String accountType;
    private String bankBranch;
    private String accountNo;
    private String chequeNo;
    private String subLedger;
    private String amount;
    private String more;
    private String linkageBranch;
    private String loanNo;
    private String bankPeriod;
    private String interestRate;

    @Column(columnDefinition = "TEXT")
    private String subLedgerLines;

    private String narration;
    private String total;

    public OtherReceipt() {}

    public Long getId() { return id; }
    public String getReceiptNo() { return receiptNo; }
    public void setReceiptNo(String value) { this.receiptNo = value; }
    public String getReceiptDate() { return receiptDate; }
    public void setReceiptDate(String value) { this.receiptDate = value; }
    public String getReceiptType() { return receiptType; }
    public void setReceiptType(String value) { this.receiptType = value; }
    public String getAccountType() { return accountType; }
    public void setAccountType(String value) { this.accountType = value; }
    public String getBankBranch() { return bankBranch; }
    public void setBankBranch(String value) { this.bankBranch = value; }
    public String getAccountNo() { return accountNo; }
    public void setAccountNo(String value) { this.accountNo = value; }
    public String getChequeNo() { return chequeNo; }
    public void setChequeNo(String value) { this.chequeNo = value; }
    public String getSubLedger() { return subLedger; }
    public void setSubLedger(String value) { this.subLedger = value; }
    public String getAmount() { return amount; }
    public void setAmount(String value) { this.amount = value; }
    public String getMore() { return more; }
    public void setMore(String value) { this.more = value; }
    public String getLinkageBranch() { return linkageBranch; }
    public void setLinkageBranch(String value) { this.linkageBranch = value; }
    public String getLoanNo() { return loanNo; }
    public void setLoanNo(String value) { this.loanNo = value; }
    public String getBankPeriod() { return bankPeriod; }
    public void setBankPeriod(String value) { this.bankPeriod = value; }
    public String getInterestRate() { return interestRate; }
    public void setInterestRate(String value) { this.interestRate = value; }
    public String getSubLedgerLines() { return subLedgerLines; }
    public void setSubLedgerLines(String value) { this.subLedgerLines = value; }
    public String getNarration() { return narration; }
    public void setNarration(String value) { this.narration = value; }
    public String getTotal() { return total; }
    public void setTotal(String value) { this.total = value; }
}
