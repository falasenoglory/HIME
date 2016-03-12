package com.jimbofer.hime.insurance_admin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jimbofer.hime.R;
import com.jimbofer.hime.fragments.ListViewFragment;

public class InsuranceAdminProfile extends AppCompatActivity {

    private ListViewFragment mListViewFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insurance_admin_profile);



//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });


        mListViewFragment = ListViewFragment.newInstance();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, mListViewFragment)
                .commit();





    }


    }

