package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "branches")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bankName;
    private String branchCode;
    private String branchName;
    private String address1;
    private String address2;
    private String state;
    private String district;
    private String pinCode;
    private String phone;
    private String ifscCode;

    public Branch() {}

    public Long getId() { return id; }

    public String getBankName() { return bankName; }
    public void setBankName(String value) { this.bankName = value; }

    public String getBranchCode() { return branchCode; }
    public void setBranchCode(String value) { this.branchCode = value; }

    public String getBranchName() { return branchName; }
    public void setBranchName(String value) { this.branchName = value; }

    public String getAddress1() { return address1; }
    public void setAddress1(String value) { this.address1 = value; }

    public String getAddress2() { return address2; }
    public void setAddress2(String value) { this.address2 = value; }

    public String getState() { return state; }
    public void setState(String value) { this.state = value; }

    public String getDistrict() { return district; }
    public void setDistrict(String value) { this.district = value; }

    public String getPinCode() { return pinCode; }
    public void setPinCode(String value) { this.pinCode = value; }

    public String getPhone() { return phone; }
    public void setPhone(String value) { this.phone = value; }

    public String getIfscCode() { return ifscCode; }
    public void setIfscCode(String value) { this.ifscCode = value; }
}

