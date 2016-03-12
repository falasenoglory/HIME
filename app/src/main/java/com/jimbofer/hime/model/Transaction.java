package com.jimbofer.hime.model;

/**
 * Created by Christian on 3/11/2016.
 */
public class Transaction {
    private String ObjectID;
    private String transactionID;
    private String patientID;
    private String insuranceID;
    private String hospitalID;
    private String doctorID;
    private String transactionType;
    private String transactionDescription;
    private String transactionDate;
    private String transactionPrice;

    public Transaction(String objectID, String transactionID, String patientID, String insuranceID, String hospitalID, String doctorID, String transactionType, String transactionDescription, String transactionDate, String transactionPrice) {
        ObjectID = objectID;
        this.transactionID = transactionID;
        this.patientID = patientID;
        this.insuranceID = insuranceID;
        this.hospitalID = hospitalID;
        this.doctorID = doctorID;
        this.transactionType = transactionType;
        this.transactionDescription = transactionDescription;
        this.transactionDate = transactionDate;
        this.transactionPrice = transactionPrice;
    }

    public String getObjectID() {
        return ObjectID;
    }

    public void setObjectID(String objectID) {
        ObjectID = objectID;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getInsuranceID() {
        return insuranceID;
    }

    public void setInsuranceID(String insuranceID) {
        this.insuranceID = insuranceID;
    }

    public String getHospitalID() {
        return hospitalID;
    }

    public void setHospitalID(String hospitalID) {
        this.hospitalID = hospitalID;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionDescription() {
        return transactionDescription;
    }

    public void setTransactionDescription(String transactionDescription) {
        this.transactionDescription = transactionDescription;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionPrice() {
        return transactionPrice;
    }

    public void setTransactionPrice(String transactionPrice) {
        this.transactionPrice = transactionPrice;
    }
}
