package com.jimbofer.hime.model;

/**
 * Created by Shanyl Jimenez on 3/13/2016.
 */
public class Appointments {
    private String AppointmentID;
    private String AppointmentDate;
    private String AppointmentPatientID;
    private String AppointmentDoctorID;
    private String AppointmentTime;
    private String Status;

    public Appointments(String appointmentID, String appointmentDate, String appointmentPatientID, String appointmentDoctorID, String appointmentTime, String status) {
        AppointmentID = appointmentID;
        AppointmentDate = appointmentDate;
        AppointmentPatientID = appointmentPatientID;
        AppointmentDoctorID = appointmentDoctorID;
        AppointmentTime = appointmentTime;
        Status = status;
    }

    public String getAppointmentID() {
        return AppointmentID;
    }

    public void setAppointmentID(String appointmentID) {
        AppointmentID = appointmentID;
    }

    public String getAppointmentDate() {
        return AppointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        AppointmentDate = appointmentDate;
    }

    public String getAppointmentPatientID() {
        return AppointmentPatientID;
    }

    public void setAppointmentPatientID(String appointmentPatientID) {
        AppointmentPatientID = appointmentPatientID;
    }

    public String getAppointmentDoctorID() {
        return AppointmentDoctorID;
    }

    public void setAppointmentDoctorID(String appointmentDoctorID) {
        AppointmentDoctorID = appointmentDoctorID;
    }

    public String getAppointmentTime() {
        return AppointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        AppointmentTime = appointmentTime;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
