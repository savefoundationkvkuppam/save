package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "other_payments")
public class OtherPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String voucherNo, voucherDate, voucherType, accountType, bankBranch;
    private String accountNo, chequeNo, shg, sahayaCovid, roc, kdfsCovid;
    private String mfKdfs, rocKdfs, upnrmKdfs, hope, bankLoanPrincipalDate;
    private String sl, cashDepositedDate, amount, amountType;
    private String subLed1, amt1, subLed2, amt2, subLed3, amt3, subLed4, amt4;
    private String subLed5, amt5, subLed6, amt6, subLed7, amt7, subLed8, amt8;

    @Column(columnDefinition = "TEXT")
    private String narration;
    private String total;

    public OtherPayment() {}

    public Long getId() { return id; }

    public String getVoucherNo() { return voucherNo; }
    public void setVoucherNo(String v) { voucherNo = v; }
    public String getVoucherDate() { return voucherDate; }
    public void setVoucherDate(String v) { voucherDate = v; }
    public String getVoucherType() { return voucherType; }
    public void setVoucherType(String v) { voucherType = v; }
    public String getAccountType() { return accountType; }
    public void setAccountType(String v) { accountType = v; }
    public String getBankBranch() { return bankBranch; }
    public void setBankBranch(String v) { bankBranch = v; }
    public String getAccountNo() { return accountNo; }
    public void setAccountNo(String v) { accountNo = v; }
    public String getChequeNo() { return chequeNo; }
    public void setChequeNo(String v) { chequeNo = v; }
    public String getShg() { return shg; }
    public void setShg(String v) { shg = v; }
    public String getSahayaCovid() { return sahayaCovid; }
    public void setSahayaCovid(String v) { sahayaCovid = v; }
    public String getRoc() { return roc; }
    public void setRoc(String v) { roc = v; }
    public String getKdfsCovid() { return kdfsCovid; }
    public void setKdfsCovid(String v) { kdfsCovid = v; }
    public String getMfKdfs() { return mfKdfs; }
    public void setMfKdfs(String v) { mfKdfs = v; }
    public String getRocKdfs() { return rocKdfs; }
    public void setRocKdfs(String v) { rocKdfs = v; }
    public String getUpnrmKdfs() { return upnrmKdfs; }
    public void setUpnrmKdfs(String v) { upnrmKdfs = v; }
    public String getHope() { return hope; }
    public void setHope(String v) { hope = v; }
    public String getBankLoanPrincipalDate() { return bankLoanPrincipalDate; }
    public void setBankLoanPrincipalDate(String v) { bankLoanPrincipalDate = v; }
    public String getSl() { return sl; }
    public void setSl(String v) { sl = v; }
    public String getCashDepositedDate() { return cashDepositedDate; }
    public void setCashDepositedDate(String v) { cashDepositedDate = v; }
    public String getAmount() { return amount; }
    public void setAmount(String v) { amount = v; }
    public String getAmountType() { return amountType; }
    public void setAmountType(String v) { amountType = v; }

    public String getSubLed1() { return subLed1; } public void setSubLed1(String v) { subLed1 = v; }
    public String getAmt1() { return amt1; } public void setAmt1(String v) { amt1 = v; }
    public String getSubLed2() { return subLed2; } public void setSubLed2(String v) { subLed2 = v; }
    public String getAmt2() { return amt2; } public void setAmt2(String v) { amt2 = v; }
    public String getSubLed3() { return subLed3; } public void setSubLed3(String v) { subLed3 = v; }
    public String getAmt3() { return amt3; } public void setAmt3(String v) { amt3 = v; }
    public String getSubLed4() { return subLed4; } public void setSubLed4(String v) { subLed4 = v; }
    public String getAmt4() { return amt4; } public void setAmt4(String v) { amt4 = v; }
    public String getSubLed5() { return subLed5; } public void setSubLed5(String v) { subLed5 = v; }
    public String getAmt5() { return amt5; } public void setAmt5(String v) { amt5 = v; }
    public String getSubLed6() { return subLed6; } public void setSubLed6(String v) { subLed6 = v; }
    public String getAmt6() { return amt6; } public void setAmt6(String v) { amt6 = v; }
    public String getSubLed7() { return subLed7; } public void setSubLed7(String v) { subLed7 = v; }
    public String getAmt7() { return amt7; } public void setAmt7(String v) { amt7 = v; }
    public String getSubLed8() { return subLed8; } public void setSubLed8(String v) { subLed8 = v; }
    public String getAmt8() { return amt8; } public void setAmt8(String v) { amt8 = v; }

    public String getNarration() { return narration; }
    public void setNarration(String v) { narration = v; }
    public String getTotal() { return total; }
    public void setTotal(String v) { total = v; }
}
