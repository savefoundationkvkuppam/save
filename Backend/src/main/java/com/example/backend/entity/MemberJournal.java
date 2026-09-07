package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "member_journals")
public class MemberJournal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String jrNo;
    private String date;
    private String member;
    private String genLedger;

    private String subLed1;
    private String type1;
    private String amt1;
    private String subLed2;
    private String type2;
    private String amt2;
    private String subLed3;
    private String type3;
    private String amt3;
    private String subLed4;
    private String type4;
    private String amt4;
    private String subLed5;
    private String type5;
    private String amt5;
    private String subLed6;
    private String type6;
    private String amt6;

    @Column(columnDefinition = "TEXT")
    private String narration;

    private String creditTotal;
    private String debitTotal;

    public MemberJournal() {}

    public Long getId() { return id; }

    public String getJrNo() { return jrNo; }
    public void setJrNo(String v) { jrNo = v; }

    public String getDate() { return date; }
    public void setDate(String v) { date = v; }

    public String getMember() { return member; }
    public void setMember(String v) { member = v; }

    public String getGenLedger() { return genLedger; }
    public void setGenLedger(String v) { genLedger = v; }

    public String getSubLed1() { return subLed1; } public void setSubLed1(String v) { subLed1 = v; }
    public String getType1() { return type1; } public void setType1(String v) { type1 = v; }
    public String getAmt1() { return amt1; } public void setAmt1(String v) { amt1 = v; }
    public String getSubLed2() { return subLed2; } public void setSubLed2(String v) { subLed2 = v; }
    public String getType2() { return type2; } public void setType2(String v) { type2 = v; }
    public String getAmt2() { return amt2; } public void setAmt2(String v) { amt2 = v; }
    public String getSubLed3() { return subLed3; } public void setSubLed3(String v) { subLed3 = v; }
    public String getType3() { return type3; } public void setType3(String v) { type3 = v; }
    public String getAmt3() { return amt3; } public void setAmt3(String v) { amt3 = v; }
    public String getSubLed4() { return subLed4; } public void setSubLed4(String v) { subLed4 = v; }
    public String getType4() { return type4; } public void setType4(String v) { type4 = v; }
    public String getAmt4() { return amt4; } public void setAmt4(String v) { amt4 = v; }
    public String getSubLed5() { return subLed5; } public void setSubLed5(String v) { subLed5 = v; }
    public String getType5() { return type5; } public void setType5(String v) { type5 = v; }
    public String getAmt5() { return amt5; } public void setAmt5(String v) { amt5 = v; }
    public String getSubLed6() { return subLed6; } public void setSubLed6(String v) { subLed6 = v; }
    public String getType6() { return type6; } public void setType6(String v) { type6 = v; }
    public String getAmt6() { return amt6; } public void setAmt6(String v) { amt6 = v; }

    public String getNarration() { return narration; }
    public void setNarration(String v) { narration = v; }

    public String getCreditTotal() { return creditTotal; }
    public void setCreditTotal(String v) { creditTotal = v; }

    public String getDebitTotal() { return debitTotal; }
    public void setDebitTotal(String v) { debitTotal = v; }
}
