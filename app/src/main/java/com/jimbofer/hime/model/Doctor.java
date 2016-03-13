package com.jimbofer.hime.model;

/**
 * Created by Christian on 3/11/2016.
 */
public class Doctor {
    private String ObjectID;
    private String DoctorId;
    private String insuranceId;
    private String HospitalId;
    private String Firstname;
    private String Lastname;
    private String Specialization;
    private String ContactNo;
    private String Gender;
    private String transactionPrice;

    public Doctor(String objectID, String doctorId, String insuranceId, String hospitalId, String firstname, String lastname, String specialization, String contactNo, String gender, String transactionPrice) {
        ObjectID = objectID;
        DoctorId = doctorId;
        this.insuranceId = insuranceId;
        HospitalId = hospitalId;
        Firstname = firstname;
        Lastname = lastname;
        Specialization = specialization;
        ContactNo = contactNo;
        Gender = gender;
        this.transactionPrice = transactionPrice;
    }

    public String getObjectID() {
        return ObjectID;
    }

    public void setObjectID(String objectID) {
        ObjectID = objectID;
    }

    public String getDoctorId() {
        return DoctorId;
    }

    public void setDoctorId(String doctorId) {
        DoctorId = doctorId;
    }

    public String getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(String insuranceId) {
        this.insuranceId = insuranceId;
    }

    public String getHospitalId() {
        return HospitalId;
    }

    public void setHospitalId(String hospitalId) {
        HospitalId = hospitalId;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getSpecialization() {
        return Specialization;
    }

    public void setSpecialization(String specialization) {
        Specialization = specialization;
    }

    public String getContactNo() {
        return ContactNo;
    }

    public void setContactNo(String contactNo) {
        ContactNo = contactNo;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getTransactionPrice() {
        return transactionPrice;
    }

    public void setTransactionPrice(String transactionPrice) {
        this.transactionPrice = transactionPrice;
    }
}
