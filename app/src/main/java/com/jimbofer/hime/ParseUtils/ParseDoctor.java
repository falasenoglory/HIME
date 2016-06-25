package com.jimbofer.hime.ParseUtils;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.jimbofer.hime.model.Doctor;
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
public class ParseDoctor {
    public static ArrayList<Doctor> parseDoctor = new ArrayList<>();
    public static Doctor doct;

    public static List<Doctor> getAllDoctor() {
        List<ParseObject> list = new ArrayList<>();
        List<Doctor> parseDoctor = new ArrayList<>();

        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Doctor");
        try {
            list = query.find();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (ParseObject obj : list) {
            Doctor doct = new Doctor(obj.getString("objectId"), obj.getString("username"), obj.getString("doctorID"), obj.getString("hospitalID"), obj.getString("Doctor"), obj.getString("doctorContactNumber"), obj.getString("doctorFirstName"), obj.getString("doctorLastName"), obj.getString("doctorSpecialization"), obj.getString("gender"), obj.getString("insuranceID"), obj.getString("transactionPrice"));
            parseDoctor.add(doct);
        }
        return parseDoctor;
    }

    public static Doctor getCertainDoctorDetails(String objID) {

        List<ParseObject> list = new ArrayList<>();

        Doctor doct = null;
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Doctor");
        query.whereEqualTo("doctorID", objID);
        try {
            list = query.find();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (ParseObject obj : list) {
            doct = new Doctor(obj.getString("objectId"), obj.getString("username"), obj.getString("doctorID"), obj.getString("hospitalID"), obj.getString("Doctor"), obj.getString("doctorContactNumber"), obj.getString("doctorFirstName"), obj.getString("doctorLastName"), obj.getString("doctorSpecialization"), obj.getString("gender"), obj.getString("insuranceID"), obj.getString("transactionPrice"));

        }
        return doct;
    }

    public static List<Doctor> getDoctorsInHospital(String hospitalId) {

        List<ParseObject> list = new ArrayList<>();
        List<Doctor> doctors = new ArrayList<>();

        Doctor doct = null;
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Doctor");
        query.whereEqualTo("hospitalID", hospitalId);
        try {
            list = query.find();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (ParseObject obj : list) {
            doctors.add(new Doctor(obj.getString("objectId"), obj.getString("username"), obj.getString("doctorID"), obj.getString("hospitalID"), obj.getString("Doctor"), obj.getString("doctorContactNumber"), obj.getString("doctorFirstName"), obj.getString("doctorLastName"), obj.getString("doctorSpecialization"), obj.getString("gender"), obj.getString("insuranceID"), obj.getString("transactionPrice")));
        }
        return doctors;
    }

    public static int ListSize() {
        List<ParseObject> list = new ArrayList<>();
        List<Doctor> parseDoctor = new ArrayList<>();

        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Doctor");
        try {
            list = query.find();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (ParseObject obj : list) {
            Doctor doct = new Doctor(obj.getString("objectId"), obj.getString("username"), obj.getString("doctorID"), obj.getString("hospitalID"), obj.getString("Doctor"), obj.getString("doctorContactNumber"), obj.getString("doctorFirstName"), obj.getString("doctorLastName"), obj.getString("doctorSpecialization"), obj.getString("gender"), obj.getString("insuranceID"), obj.getString("transactionPrice"));
            parseDoctor.add(doct);
        }
        return Integer.parseInt(parseDoctor.get(parseDoctor.size() - 1).getDoctorId());

    }

    public void addDoctor(String objectID, String username, String doctorId, String hospitalId, String doctor, String contactNo, String firstname, String lastname, String specialization, String gender, String insuranceId, String transactionPrice) {
        int DoctorID = ListSize() + 1;
        ParseObject storyActivity = new ParseObject("Doctor");
        storyActivity.put("username", username);
        storyActivity.put("doctorID", doctorId);
        storyActivity.put("hospitalID", hospitalId);
        storyActivity.put("Doctor", doctor);
        storyActivity.put("doctorContactNumber", contactNo);
        storyActivity.put("doctorFirstName", firstname);
        storyActivity.put("doctorLastName", lastname);
        storyActivity.put("doctorSpecialization", specialization);
        storyActivity.put("gender", gender);
        storyActivity.put("insuranceID", insuranceId);
        storyActivity.put("transactionPrice", transactionPrice);

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

    public void deleteDoctor(String objID) {
        ParseQuery<ParseObject> query2 = ParseQuery.getQuery("Doctor");
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
}

