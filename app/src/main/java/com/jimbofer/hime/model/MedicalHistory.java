package com.jimbofer.hime.model;

/**
 * Created by Christian on 3/11/2016.
 */
public class MedicalHistory {
    private String ObjectID;
    private String dateDiagnose;
    private String medHistory;
    private String PatientID;

    public MedicalHistory(String objectID, String dateDiagnose, String medHistory, String patientID) {
        ObjectID = objectID;
        this.dateDiagnose = dateDiagnose;
        this.medHistory = medHistory;
        PatientID = patientID;
    }

    public String getObjectID() {
        return ObjectID;
    }

    public void setObjectID(String objectID) {
        ObjectID = objectID;
    }

    public String getDateDiagnose() {
        return dateDiagnose;
    }

    public void setDateDiagnose(String dateDiagnose) {
        this.dateDiagnose = dateDiagnose;
    }

    public String getMedHistory() {
        return medHistory;
    }

    public void setMedHistory(String medHistory) {
        this.medHistory = medHistory;
    }

    public String getPatientID() {
        return PatientID;
    }

    public void setPatientID(String patientID) {
        PatientID = patientID;
    }
}
