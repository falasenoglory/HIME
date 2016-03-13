package com.jimbofer.hime.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.jimbofer.hime.R;
import com.jimbofer.hime.fragments.ListViewFragmentDoctor;

public class DoctorProfile extends AppCompatActivity {
    private ListViewFragmentDoctor mListViewFragmentDoctor;

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





    }
    }


