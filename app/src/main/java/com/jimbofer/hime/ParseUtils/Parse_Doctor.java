package com.jimbofer.hime.ParseUtils;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.jimbofer.hime.Constants;
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
public class Parse_Doctor {
    public static ArrayList<Doctor> parseDoctor = new ArrayList<>();
    public static Doctor doct;

    public static ArrayList<Doctor> getAllDoctor(){
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Doctor");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> markers, ParseException e) {
                if (e == null) {
                    for (ParseObject obj : markers) {
                        Doctor doc = new Doctor(obj.getString("objectId"),obj.getString("doctorID"),obj.getString("insuranceID"),obj.getString("hospitalID"),obj.getString("doctorFirstName"),obj.getString("doctorLastName"),obj.getString("doctorSpecialization"),obj.getString("doctorContactNumber"),obj.getString("gender"),obj.getString("transactionPrice"));
                        parseDoctor.add(doc);
                    }

                } else {
                    // handle Parse Exception here
                }
            }

    });
        return parseDoctor;
}
    public static Doctor getCertainDoctorDetails(String objID){

        ParseQuery<ParseObject> query2 = ParseQuery.getQuery("Doctor");
        query2.whereEqualTo("objectId", objID);
        query2.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, ParseException e) {
                if (e == null) {
                    for (ParseObject obj : list) {
                        doct = new Doctor(obj.getString("objectId"),obj.getString("doctorID"),obj.getString("insuranceID"),obj.getString("hospitalID"),obj.getString("doctorFirstName"),obj.getString("doctorLastName"),obj.getString("doctorSpecialization"),obj.getString("doctorContactNumber"),obj.getString("gender"),obj.getString("transactionPrice"));

                    }
                }else{
                    Log.d("role_patient error", "e");
                }

            }
        });
        if(doct!=null) {
            return doct;
        }
        else {
            Log.d("Error", "Returned null (Get certain)");
            return doct;
        }
    }
    public static int ListSize(){
        final ArrayList<Doctor> List= new ArrayList<>();
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Doctor");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> markers, ParseException e) {
                if (e == null) {
                    for (ParseObject obj : markers) {
                        Doctor docl = new Doctor(obj.getString("objectId"),obj.getString("doctorID"),obj.getString("insuranceID"),obj.getString("hospitalID"),obj.getString("doctorFirstName"),obj.getString("doctorLastName"),obj.getString("doctorSpecialization"),obj.getString("doctorContactNumber"),obj.getString("gender"),obj.getString("transactionPrice"));
                        List.add(docl);
                    }

                } else {
                    // handle Parse Exception here
                }
            }

        });
        return  Integer.parseInt(List.get(List.size() - 1).getDoctorId());
    }
    public void addDoctor(String hospID,String insID,String fname,String lname,String specialization,String contactNo,String gender,String transPrice){
        int DoctorID = ListSize()+1;
        ParseObject storyActivity = new ParseObject("Doctor");
        storyActivity.put("doctorID", DoctorID);
        storyActivity.put("hospitalID", hospID);
        storyActivity.put("insuranceID",insID);
        storyActivity.put("doctorFirstName",fname);
        storyActivity.put("doctorLastName",lname);
        storyActivity.put("doctorSpecialization",specialization);
        storyActivity.put("doctorContactNumber",contactNo);
        storyActivity.put("gender", gender);
        storyActivity.put("transactionPrice", transPrice);

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
    public void deleteDoctor(String objID){
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
    public void editDoctor(String objID,String hospID,String insID,String fname,String lname,String specialization,String contactNo,String gender,String transPrice){
        deleteDoctor(objID);
        addDoctor(hospID, insID, fname, lname, specialization, contactNo, gender, transPrice);
    }
}

