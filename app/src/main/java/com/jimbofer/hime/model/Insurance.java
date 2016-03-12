package com.jimbofer.hime.model;

/**
 * Created by Christian on 3/11/2016.
 */
public class Insurance {
    private String ObjectID;
    private String insuranceID;
    private String insuranceName;
    private String insurancePolicy;
    private String insuranceContactNo;
    private String insuranceAddress;

    public Insurance(String objectID, String insuranceID, String insuranceName, String insurancePolicy, String insuranceContactNo, String insuranceAddress) {
        ObjectID = objectID;
        this.insuranceID = insuranceID;
        this.insuranceName = insuranceName;
        this.insurancePolicy = insurancePolicy;
        this.insuranceContactNo = insuranceContactNo;
        this.insuranceAddress = insuranceAddress;
    }

    public String getObjectID() {
        return ObjectID;
    }

    public void setObjectID(String objectID) {
        ObjectID = objectID;
    }

    public String getInsuranceID() {
        return insuranceID;
    }

    public void setInsuranceID(String insuranceID) {
        this.insuranceID = insuranceID;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public String getInsurancePolicy() {
        return insurancePolicy;
    }

    public void setInsurancePolicy(String insurancePolicy) {
        this.insurancePolicy = insurancePolicy;
    }

    public String getInsuranceContactNo() {
        return insuranceContactNo;
    }

    public void setInsuranceContactNo(String insuranceContactNo) {
        this.insuranceContactNo = insuranceContactNo;
    }

    public String getInsuranceAddress() {
        return insuranceAddress;
    }

    public void setInsuranceAddress(String insuranceAddress) {
        this.insuranceAddress = insuranceAddress;
    }
}
