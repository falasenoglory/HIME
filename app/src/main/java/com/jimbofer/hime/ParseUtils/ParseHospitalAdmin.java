package com.jimbofer.hime.ParseUtils;

import android.util.Log;

import com.jimbofer.hime.model.HospitalAdmin;
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
public class ParseHospitalAdmin {
    public static ArrayList<HospitalAdmin> parseHospitalAdmin = new ArrayList<>();
    public static HospitalAdmin hosAd;

    public static List<HospitalAdmin> getAllHospitalAdmin(){
        List<ParseObject> list = new ArrayList<>();
        List<HospitalAdmin> parseHospital = new ArrayList<>();

        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Hospital");
        try {
            list = query.find();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (ParseObject obj : list) {
           HospitalAdmin hosp = new HospitalAdmin(obj.getString("objectId"),obj.getString("hospitalID"),obj.getString("hospitalName"),obj.getString("hospitalAddress"),obj.getString("hospitalHMOContactNumber"),obj.getString("longitude"),obj.getString("latitude"));
            parseHospital.add(hosp);
    }
        return parseHospital;
    }
    public static HospitalAdmin getCertainHospitalAdminDetails(String objID){


        List<ParseObject> list = new ArrayList<>();

        HospitalAdmin hosp = null;
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Hospital");
        query.whereEqualTo("objectId", objID);
        try {
            list = query.find();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (ParseObject obj : list) {
           hosp = new HospitalAdmin(obj.getString("objectId"),obj.getString("hospitalID"),obj.getString("hospitalName"),obj.getString("hospitalAddress"),obj.getString("hospitalHMOContactNumber"),obj.getString("longitude"),obj.getString("latitude"));

        }
        return hosp;
    }
    public static int ListSize(){
        List<ParseObject> list = new ArrayList<>();
        List<HospitalAdmin> parseHospital = new ArrayList<>();

        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Hospital");
        try {
            list = query.find();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (ParseObject obj : list) {
           HospitalAdmin hosp= new HospitalAdmin(obj.getString("objectId"),obj.getString("hospitalID"),obj.getString("hospitalName"),obj.getString("hospitalAddress"),obj.getString("hospitalHMOContactNumber"),obj.getString("longitude"),obj.getString("latitude"));
            parseHospital.add(hosp);
        }
        return Integer.parseInt(parseHospital.get(parseHospital.size() - 1).getHospitalId());
    }
    public void addHospital(String hospname, String hospadd, String hospHMOConNo, String lat,String lang){
        int HospitalID = ListSize()+1;
        ParseObject storyActivity = new ParseObject("Hospital");
        storyActivity.put("hospitalID", HospitalID);
        storyActivity.put("hospitalName", hospname);
        storyActivity.put("hospitalAddres",hospadd);
        storyActivity.put("hospitalHMOContactNumber",hospHMOConNo);
        storyActivity.put("latitude",lat);
        storyActivity.put("longitude",lang);

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
    public void deleteHospital(String objID){
        ParseQuery<ParseObject> query2 = ParseQuery.getQuery("Hospital");
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
    public void editHospital(String objID, String hospname, String hospadd, String hospHMOConNo, String lat,String lang){
        deleteHospital(objID);
        addHospital(hospname, hospadd, hospHMOConNo, lat, lang);
    }
}
