package com.jimbofer.hime.ParseUtils;

import android.util.Log;

import com.jimbofer.hime.model.Insurance;
import com.jimbofer.hime.model.MedicalHistory;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christian on 3/11/2016.
 */
public class ParseInsurance {
    public static ArrayList<Insurance> parseDoctor = new ArrayList<>();
    public static Insurance ins;

    public static List<Insurance> getAllInsurance(){
        List<ParseObject> list = new ArrayList<>();
        List<Insurance> parseInsurance = new ArrayList<>();

        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Insurance");
        try {
            list = query.find();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (ParseObject obj : list) {
            Insurance ins = new Insurance(obj.getString("objectId"),obj.getString("insuranceID"),obj.getString("insuranceName"),obj.getString("insurancePolicy"),obj.getString("insuranceContactNumber"),obj.getString("insuranceAddress"));
            parseInsurance.add(ins);
        }
        return parseInsurance;
        }
    public static Insurance getCertainInsurancDetails(String objID) {


        List<ParseObject> list = new ArrayList<>();

        Insurance ins = null;
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Insurance");
        query.whereEqualTo("objectId", objID);
        try {
            list = query.find();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (ParseObject obj : list) {
            ins = new Insurance(obj.getString("objectId"),obj.getString("insuranceID"),obj.getString("insuranceName"),obj.getString("insurancePolicy"),obj.getString("insuranceContactNumber"),obj.getString("insuranceAddress"));

        }
        return ins;
    }
}
