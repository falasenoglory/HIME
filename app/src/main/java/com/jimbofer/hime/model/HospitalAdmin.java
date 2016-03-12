package com.jimbofer.hime.model;

/**
 * Created by Christian on 3/11/2016.
 */
public class HospitalAdmin {
    private String ObjectID;
    private String hospitalId;
    private String hospitalName;
    private String hospitalAddress;
    private String HospitalHMOContactNumber;
    private String longitude;
    private String latitude;

    public HospitalAdmin(String objectID, String hospitalId, String hospitalName, String hospitalAddress, String hospitalHMOContactNumber, String longitude, String latitude) {
        ObjectID = objectID;
        this.hospitalId = hospitalId;
        this.hospitalName = hospitalName;
        this.hospitalAddress = hospitalAddress;
        HospitalHMOContactNumber = hospitalHMOContactNumber;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getObjectID() {
        return ObjectID;
    }

    public void setObjectID(String objectID) {
        ObjectID = objectID;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalAddress() {
        return hospitalAddress;
    }

    public void setHospitalAddress(String hospitalAddress) {
        this.hospitalAddress = hospitalAddress;
    }

    public String getHospitalHMOContactNumber() {
        return HospitalHMOContactNumber;
    }

    public void setHospitalHMOContactNumber(String hospitalHMOContactNumber) {
        HospitalHMOContactNumber = hospitalHMOContactNumber;
    }
}
