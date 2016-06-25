package com.jimbofer.hime.ParseUtils;

import android.util.Log;

import com.jimbofer.hime.model.Patient;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christian on 3/11/2016.
 */
public class ParsePatient {
    public static ArrayList<Patient> parsePatient = new ArrayList<>();
    public static Patient pat;
    public static int size;

    public static List<Patient> getAllPatient() {
        List<ParseObject> list = new ArrayList<>();
        List<Patient> parsePatient = new ArrayList<>();

        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Patient");
        try {
            list = query.find();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (ParseObject obj : list) {
            Patient pat = new Patient(obj.getString("objectId"), obj.getString("Username"), obj.getString("Insurance_ID"), obj.getString("PatientID"), obj.getString("firstName"), obj.getString("lastName"), obj.getString("MiddleInitial"), obj.getString("address"), obj.getString("birthday"), obj.getString("contactNo"), obj.getString("gender"), obj.getString("medicalHistory"), obj.getString("patientRemainingInsuranceBalance"));
            parsePatient.add(pat);
        }
        return parsePatient;
    }

    public static Patient getCertainPatientDetails(String objID) {

        List<ParseObject> list = new ArrayList<>();

        Patient pat = null;
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Patient");
        query.whereEqualTo("Username", objID);
        try {
            list = query.find();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (ParseObject obj : list) {
            pat = new Patient(obj.getString("objectId"), obj.getString("Username"), obj.getString("Insurance_ID"), obj.getString("PatientID"), obj.getString("firstName"), obj.getString("lastName"), obj.getString("MiddleInitial"), obj.getString("address"), obj.getString("birthday"), obj.getString("contactNo"), obj.getString("gender"), obj.getString("medicalHistory"), obj.getString("patientRemainingInsuranceBalance"));
        }
        return pat;
    }

    public static int ListSize() {
        List<ParseObject> list = new ArrayList<>();
        List<Patient> parsePatient = new ArrayList<>();

        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Patient");
        try {
            list = query.find();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (ParseObject obj : list) {
            Patient pat = new Patient(obj.getString("objectId"), obj.getString("Username"), obj.getString("Insurance_ID"), obj.getString("PatientID"), obj.getString("firstName"), obj.getString("lastName"), obj.getString("MiddleInitial"), obj.getString("address"), obj.getString("birthday"), obj.getString("contactNo"), obj.getString("gender"), obj.getString("medicalHistory"), obj.getString("patientRemainingInsuranceBalance"));parsePatient.add(pat);
        }
        return Integer.parseInt(parsePatient.get(parsePatient.size() - 1).getPatientID());
    }

    public void addPatient(String username, String insuranceID, String patientID, String firstName, String lastName, String middleInitial, String address, String birthday, String contactNo, String gender, String medicalHistory, String patientRemainingInsuranceBalance) {
        int PatientID = ListSize() + 1;
        ParseObject storyActivity = new ParseObject("Patient");
        storyActivity.put("Username", username);
        storyActivity.put("Insurance_ID", insuranceID);
        storyActivity.put("PatientID", patientID);
        storyActivity.put("firstName", firstName);
        storyActivity.put("lastName", lastName);
        storyActivity.put("MiddleInitial", middleInitial);
        storyActivity.put("address", address);
        storyActivity.put("birthday", birthday);
        storyActivity.put("coontactNo", contactNo);
        storyActivity.put("gender", gender);
        storyActivity.put("medicalHistory", medicalHistory);
        storyActivity.put("patientRemainingInsuranceBalance", patientRemainingInsuranceBalance);

        storyActivity.saveInBackground(new SaveCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    // your object is successfully created.
                } else {
                    //error occurred
                    Log.d("Error", "Nothing added , Exception " + e);
                }
            }
        });

    }

    public void deletePatient(String objID) {
        ParseQuery<ParseObject> query2 = ParseQuery.getQuery("Patient");
        query2.whereEqualTo("objectId", objID);
        query2.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, ParseException e) {
                if (e == null) {

                    for (ParseObject obj : list) {

                        try {
                            obj.delete();

                        } catch (ParseException e1) {
                            e1.printStackTrace();
                        }


                    }


                } else {

                }
            }
        });
    }

//    public void editPatient(String objID, String insuranceID, String fname, String lname, String address, String bday, String medhis, String gender, String insbal, String cno) {
//        deletePatient(objID);
//        addPatient(insuranceID, fname, lname, address, bday, medhis, gender, insbal, cno);
//    }

}
