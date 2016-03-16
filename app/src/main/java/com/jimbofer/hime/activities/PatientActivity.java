package com.jimbofer.hime.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.jimbofer.hime.ParseUtils.ParsePatient;
import com.jimbofer.hime.R;
import com.jimbofer.hime.constants.Constants;
import com.jimbofer.hime.fragments.ProfileFragment;
import com.jimbofer.hime.fragments.TransactionFragment;
import com.jimbofer.hime.model.Patient;

public class PatientActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static Patient patient;
    private static String username;
    private static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        fragmentManager = getFragmentManager();

        Intent intent = getIntent();
        username = intent.getStringExtra(Constants.USERNAME_KEY);

        navigationView.setCheckedItem(R.id.nav_account);
        new PerformNavDrawTask().execute();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Fragment fragment = null;
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_account) {
            fragment = new ProfileFragment();
            Bundle bundle = new Bundle();
            bundle.putString(Constants.PARSE_PATIENTID_KEY, patient.getPatientID());
            bundle.putString(Constants.PARSE_BIRTHDAY_KEY, patient.getBirthday());
            bundle.putString(Constants.PARSE_ADDRESS_KEY, patient.getAddress());
            bundle.putString(Constants.PARSE_GENDER_KEY, patient.getGender());
            bundle.putString(Constants.PARSE_CONTACTNUM_KEY, patient.getContactNo());
            fragment.setArguments(bundle);
            Toast.makeText(getApplicationContext(), "Kayat", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_history) {
            //do something..
        } else if (id == R.id.nav_transaction) {
            fragment = new TransactionFragment();
            Bundle bundle = new Bundle();
            bundle.putString(Constants.PARSE_PATIENTID_KEY, patient.getPatientID());
            fragment.setArguments(bundle);
        } else if (id == R.id.nav_hospital) {
            //do something
        } else if (id == R.id.nav_insurance) {
            //do something..
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, fragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public static class PerformNavDrawTask extends AsyncTask<Void, Void, Patient>

    {

        @Override
        protected Patient doInBackground(Void... params) {
            return ParsePatient.getCertainPatientDetails(username);
        }

        @Override
        protected void onPostExecute(Patient taskPatient) {
            patient = taskPatient;
        Fragment fragment = new ProfileFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.PARSE_FIRSTNAME_KEY, patient.getFirstName());
        bundle.putString(Constants.PARSE_LASTNAME_KEY, patient.getLastName());
        bundle.putString(Constants.PARSE_PATIENTID_KEY, patient.getPatientID());
        bundle.putString(Constants.PARSE_BIRTHDAY_KEY, patient.getBirthday());
        bundle.putString(Constants.PARSE_ADDRESS_KEY, patient.getAddress());
        bundle.putString(Constants.PARSE_GENDER_KEY, patient.getGender());
        bundle.putString(Constants.PARSE_CONTACTNUM_KEY, patient.getContactNo());
        fragment.setArguments(bundle);
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment).commit();
        }
    }
}
