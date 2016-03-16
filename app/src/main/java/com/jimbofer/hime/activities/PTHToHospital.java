package com.jimbofer.hime.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jimbofer.hime.R;
import com.jimbofer.hime.model.HospitalAdmin;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eugene Boholst on 3/16/2016.
 */
public class PTHToHospital extends AppCompatActivity{
    public static String hospid;
    public static String longi,lati;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
//
            Intent i = getIntent();
            hospid = i.getStringExtra("HospitalID");

            List<ParseObject> list = new ArrayList<>();

            HospitalAdmin hosp = null;
            ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Hospital");
            query.whereEqualTo("hospitalID", hospid);
            try {
                list = query.find();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            for (ParseObject obj : list) {
                hosp = new HospitalAdmin(obj.getString("objectId"),obj.getString("hospitalID"),obj.getString("hospitalName"),obj.getString("hospitalAddress"),obj.getString("hospitalHMOContactNumber"),obj.getString("longitude"),obj.getString("latitude"));

            }
            if (hosp != null) {
                longi = hosp.getLongitude();
                lati = hosp.getLatitude();
            }
            Uri gmmIntentUri = Uri.parse("google.navigation:q=" + longi + "," + lati);
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);

        }
}
