package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "mutual_life_scholarships")
public class MutualLifeScholarship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String licIdNo;

    private String memberName;

    private String studentName;

    private String gender;

    private String schoolName;

    private String standard;

    private String accountHolderName;

    private String accountNumber;

    private String bankName;

    private String branchName;

    private String receivedDate;

    private String receivedAmount;

    public MutualLifeScholarship() {
    }

    public Long getId() { return id; }

    public String getLicIdNo() { return licIdNo; }
    public void setLicIdNo(String licIdNo) { this.licIdNo = licIdNo; }

    public String getMemberName() { return memberName; }
    public void setMemberName(String memberName) { this.memberName = memberName; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getSchoolName() { return schoolName; }
    public void setSchoolName(String schoolName) { this.schoolName = schoolName; }

    public String getStandard() { return standard; }
    public void setStandard(String standard) { this.standard = standard; }

    public String getAccountHolderName() { return accountHolderName; }
    public void setAccountHolderName(String accountHolderName) { this.accountHolderName = accountHolderName; }

    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }

    public String getBankName() { return bankName; }
    public void setBankName(String bankName) { this.bankName = bankName; }

    public String getBranchName() { return branchName; }
    public void setBranchName(String branchName) { this.branchName = branchName; }

    public String getReceivedDate() { return receivedDate; }
    public void setReceivedDate(String receivedDate) { this.receivedDate = receivedDate; }

    public String getReceivedAmount() { return receivedAmount; }
    public void setReceivedAmount(String receivedAmount) { this.receivedAmount = receivedAmount; }

}

