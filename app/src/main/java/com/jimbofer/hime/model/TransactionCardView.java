package com.jimbofer.hime.model;

/**
 * Created by Eugene Boholst on 3/16/2016.
 */
public class TransactionCardView {
    String transactionID;
    String day;
    String year;
    String hospitalName;
    String doctorName;

    public TransactionCardView(String transactionID, String day, String year, String hospitalName, String doctorName) {
        this.transactionID = transactionID;
        this.day = day;
        this.year = year;
        this.hospitalName = hospitalName;
        this.doctorName = doctorName;
    }

    public String getDay() {
        return day;
    }

    public String getYear() {
        return year;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getTransactionID() {
        return transactionID;
    }
}
