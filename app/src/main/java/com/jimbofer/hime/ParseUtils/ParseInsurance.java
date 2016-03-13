package com.jimbofer.hime.ParseUtils;

import android.util.Log;

import com.jimbofer.hime.model.Insurance;
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

    public static ArrayList<Insurance> getAllInsurance(){
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Insurance");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> markers, ParseException e) {
                if (e == null) {
                    for (ParseObject obj : markers) {
                        Insurance insurance = new Insurance(obj.getString("objectId"),obj.getString("insuranceID"),obj.getString("insuranceName"),obj.getString("insurancePolicy"),obj.getString("insuranceContactNumber"),obj.getString("insuranceAddress"));
                        parseDoctor.add(insurance);
                    }

                } else {
                    // handle Parse Exception here
                }
            }

        });
        return parseDoctor;
    }
    public static Insurance getCertainInsurancDetails(String objID){

        ParseQuery<ParseObject> query2 = ParseQuery.getQuery("Insurance");
        query2.whereEqualTo("objectId", objID);
        query2.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, ParseException e) {
                if (e == null) {
                    for (ParseObject obj : list) {
                        ins = new Insurance(obj.getString("objectId"),obj.getString("insuranceID"),obj.getString("insuranceName"),obj.getString("insurancePolicy"),obj.getString("insuranceContactNumber"),obj.getString("insuranceAddress"));

                    }
                }else{
                    Log.d("role_patient error", "e");
                }

            }
        });
        if(ins!=null) {
            return ins;
        }
        else {
            Log.d("Error", "Returned null (Get certain)");
            return ins;
        }
    }
}
