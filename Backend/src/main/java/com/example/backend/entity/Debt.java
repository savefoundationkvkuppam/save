package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "debts")
public class Debt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long memberId;
    private String memberName;
    private String debtType;
    private String source;
    private String loanAmount;
    private String presentOutstanding;
    private String borrowingYear;
    private String interestRate;
    private String loanPurpose;
    private String repaymentFrequency;

    public Debt() {}
    public Long getId(){return id;}
    public Long getMemberId(){return memberId;} public void setMemberId(Long v){memberId=v;}
    public String getMemberName(){return memberName;} public void setMemberName(String v){memberName=v;}
    public String getDebtType(){return debtType;} public void setDebtType(String v){debtType=v;}
    public String getSource(){return source;} public void setSource(String v){source=v;}
    public String getLoanAmount(){return loanAmount;} public void setLoanAmount(String v){loanAmount=v;}
    public String getPresentOutstanding(){return presentOutstanding;} public void setPresentOutstanding(String v){presentOutstanding=v;}
    public String getBorrowingYear(){return borrowingYear;} public void setBorrowingYear(String v){borrowingYear=v;}
    public String getInterestRate(){return interestRate;} public void setInterestRate(String v){interestRate=v;}
    public String getLoanPurpose(){return loanPurpose;} public void setLoanPurpose(String v){loanPurpose=v;}
    public String getRepaymentFrequency(){return repaymentFrequency;} public void setRepaymentFrequency(String v){repaymentFrequency=v;}
}

