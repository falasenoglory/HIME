package com.jimbofer.hime.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.jimbofer.hime.R;
import com.jimbofer.hime.constants.Constants;
import com.jimbofer.hime.fragments.ListViewFragmentDoctor;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

public class DoctorProfile extends AppCompatActivity {
    private ListViewFragmentDoctor mListViewFragmentDoctor;
    private TextView doctName;
    private TextView doctSpecialization;
    private TextView doctContactNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mListViewFragmentDoctor = ListViewFragmentDoctor.newInstance();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.doctorFragmentContainer, mListViewFragmentDoctor)
                .commit();

        doctName = (TextView) findViewById(R.id.txtDoctorName);
        doctSpecialization=(TextView) findViewById(R.id.txtSpecialization);
        doctContactNumber=(TextView) findViewById(R.id.txtContactNo);

        Toast.makeText(getApplicationContext(), "Doctor Profile", Toast.LENGTH_SHORT).show();
        String username = null;
        Intent i = getIntent();
        username = i.getStringExtra(Constants.USERNAME_KEY);

        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Memorabilia");
        query.whereEqualTo("Doctor", username);
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, ParseException e) {
                if (e == null) {

                    for (ParseObject obj : list) {

                    doctName.setText(obj.getString("doctorFirstName")+","+obj.getString("doctorLastName"));
                        doctSpecialization.setText(obj.getString("doctorSpecialization"));
                        doctContactNumber.setText(obj.getString("doctorContactNumber"));
                        Bundle bundle = new Bundle();
            bundle.putString("doctorUsername", (String) doctName.getText());
                        Log.d("Chan",obj.getString("doctorFirstName"));





                    }


                } else {
                    Log.d("Chan",e.toString());
                }
            }
        });

    }
    }


