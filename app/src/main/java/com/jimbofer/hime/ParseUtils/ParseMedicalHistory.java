package com.jimbofer.hime.ParseUtils;

import android.util.Log;

import com.jimbofer.hime.model.MedicalHistory;
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
public class ParseMedicalHistory {
    public static ArrayList<MedicalHistory> parseMedHistory = new ArrayList<>();
    public static MedicalHistory medh;

    public static List<MedicalHistory> getAllMedicalHistory(){
        List<ParseObject> list = new ArrayList<>();
        List<MedicalHistory> parseMedicalHistory = new ArrayList<>();

        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("MedicalHistory");
        try {
            list = query.find();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (ParseObject obj : list) {
            MedicalHistory medhis = new MedicalHistory(obj.getString("objectId"),obj.getString("dateDiagnose"),obj.getString("medHistory"),obj.getString("patientID"));
            parseMedicalHistory.add(medhis);
        }
        return parseMedicalHistory;
    }
    public static MedicalHistory getCertainMedicalHistoryDetails(String objID){

        List<ParseObject> list = new ArrayList<>();

        MedicalHistory medhis = null;
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("MedicalHistory");
        query.whereEqualTo("objectId", objID);
        try {
            list = query.find();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (ParseObject obj : list) {
           medhis = new MedicalHistory(obj.getString("objectId"),obj.getString("dateDiagnose"),obj.getString("medHistory"),obj.getString("patientID"));

        }
        return medhis;
    }
    public static int ListSize(){
        List<ParseObject> list = new ArrayList<>();
        List<MedicalHistory> parsePatient = new ArrayList<>();

        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("MedicalHistory");
        try {
            list = query.find();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (ParseObject obj : list) {
            MedicalHistory medhis = new MedicalHistory(obj.getString("objectId"),obj.getString("dateDiagnose"),obj.getString("medHistory"),obj.getString("patientID"));
            parsePatient.add(medhis);
        }
        return parsePatient.size();
    }
    public void addMedicalHistory(String PatientID,String datediag,String medhis){

        ParseObject storyActivity = new ParseObject("MedicalHistory");
        storyActivity.put("patientID", PatientID);
        storyActivity.put("dateDiagnose", datediag);
        storyActivity.put("medHistory",medhis);
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
    public void deleteMedicalHistory(String objID){
        ParseQuery<ParseObject> query2 = ParseQuery.getQuery("MedicalHistory");
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
    public void editMedicalHistory(String objID,String PatientID,String datediag,String medhis){
        deleteMedicalHistory(objID);
        addMedicalHistory(PatientID,datediag,medhis);
    }


}
