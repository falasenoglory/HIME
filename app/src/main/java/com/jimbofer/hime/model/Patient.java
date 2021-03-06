package com.jimbofer.hime.model;

/**
 * Created by Christian on 3/11/2016.
 */
public class Patient {
    private String ObjectID;
    private String username;
    private String insuranceID;
    private String patientID;
    private String firstName;
    private String lastName;
    private String middleInitial;
    private String address;
    private String birthday;
    private String medicalHistory;
    private String gender;
    private String patientRemainingInsuranceBalance;
    private String contactNo;

    public Patient(String objectID, String username, String insuranceID, String patientID, String firstName, String lastName, String middleInitial, String address, String birthday, String contactNo, String gender, String medicalHistory, String patientRemainingInsuranceBalance) {
        ObjectID = objectID;
        this.username = username;
        this.insuranceID = insuranceID;
        this.patientID = patientID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInitial = middleInitial;
        this.address = address;
        this.birthday = birthday;
        this.medicalHistory = medicalHistory;
        this.gender = gender;
        this.patientRemainingInsuranceBalance = patientRemainingInsuranceBalance;
        this.contactNo = contactNo;
    }

    public String getObjectID() {
        return ObjectID;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
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

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPatientRemainingInsuranceBalance() {
        return patientRemainingInsuranceBalance;
    }

    public void setPatientRemainingInsuranceBalance(String patientRemainingInsuranceBalance) {
        this.patientRemainingInsuranceBalance = patientRemainingInsuranceBalance;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }
}
