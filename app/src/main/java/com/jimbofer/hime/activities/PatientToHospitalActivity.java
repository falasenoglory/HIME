package com.jimbofer.hime.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jimbofer.hime.ParseUtils.ParseAppointments;
import com.jimbofer.hime.ParseUtils.ParseDoctor;
import com.jimbofer.hime.ParseUtils.ParseHospitalAdmin;
import com.jimbofer.hime.R;
import com.jimbofer.hime.constants.User;
import com.jimbofer.hime.fragments.DialogBox;
import com.jimbofer.hime.model.Doctor;
import com.jimbofer.hime.model.HospitalAdmin;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class PatientToHospitalActivity extends AppCompatActivity {

    private static String hospid;
    private static String longi, lati;
    private static String doctorID, dentistID;
    private static int transactionSize;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_to_hospital);

        Intent i = getIntent();
        hospid = i.getStringExtra("HospitalID");
        new FetchHospital().execute();
    }

    public void cardView1(View view) {
        User.doctorID = doctorID;
        final DialogBox doctorDialog = new DialogBox();
        doctorDialog.show(getFragmentManager(), "Fragment");
        doctorDialog.setOnItemClickListener(new DialogBox.OnItemClickListener() {
            @Override
            public void onOkItemClickListener() {
                ParseAppointments.addAppointment(doctorDialog.getDate(), "8:00", User.doctorID, User.patientID);
                doctorDialog.dismiss();
            }

            @Override
            public void onCancelItemClickListener() {
                doctorDialog.dismiss();
            }
        });
    }

    public void cardView2(View view) {
        User.doctorID = dentistID;
        final DialogBox doctorDialog = new DialogBox();
        doctorDialog.show(getFragmentManager(), "Fragment");
        doctorDialog.setOnItemClickListener(new DialogBox.OnItemClickListener() {
            @Override
            public void onOkItemClickListener() {
                ParseAppointments.addAppointment(doctorDialog.getDate(), "8:00", User.doctorID, User.patientID);
                doctorDialog.dismiss();
            }

            @Override
            public void onCancelItemClickListener() {
                doctorDialog.dismiss();
            }
        });
    }

    public void cardView3(View view) {
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
            hosp = new HospitalAdmin(obj.getString("objectId"), obj.getString("hospitalID"), obj.getString("hospitalName"), obj.getString("hospitalAddress"), obj.getString("hospitalHMOContactNumber"), obj.getString("longitude"), obj.getString("latitude"));

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

    public class FetchHospital extends AsyncTask<Void, Void, List<Doctor>> {
        private HospitalAdmin hospital;
        private TextView mDoctorName;
        private TextView mSpecialty;
        private TextView mDoctorNumber;
        private TextView mDentistName;
        private TextView mDentistNumber;
        private TextView mHospitalName;
        private TextView mHospitalAddress;
        private TextView mContactNumber;

        @Override
        protected void onPreExecute() {
            mDoctorName = (TextView) findViewById(R.id.doctorName);
            mSpecialty = (TextView) findViewById(R.id.specialty);
            mDoctorNumber = (TextView) findViewById(R.id.doctorNumber);
            mDentistName = (TextView) findViewById(R.id.dentistName);
            mDentistNumber = (TextView) findViewById(R.id.dentistNumber);
            mHospitalName = (TextView) findViewById(R.id.hospitalName);
            mHospitalAddress = (TextView) findViewById(R.id.hospitalAddress);
            mContactNumber = (TextView) findViewById(R.id.contactNumber);
        }

        @Override
        protected List<Doctor> doInBackground(Void... params) {
            transactionSize = ParseAppointments.ListSize();
            hospital = ParseHospitalAdmin.getCertainHospitalAdminDetails(hospid);
            return ParseDoctor.getDoctorsInHospital(hospid);
        }

        @Override
        protected void onPostExecute(List<Doctor> doctors) {
            User.transactionSize = transactionSize;
            String name;
            Doctor doctor = doctors.get(0);
            doctorID = doctor.getDoctorId();
            name = "Dr. " + doctor.getFirstname() + " " + doctor.getLastname();
            mDoctorName.setText(name);
            mSpecialty.setText(doctor.getSpecialization());
            mDoctorNumber.setText(doctor.getContactNo());
            if (doctors.size() == 2) {
                doctor = doctors.get(1);
                name = "Dr. " + doctor.getFirstname() + " " + doctor.getLastname();
                mDentistName.setText(name);
                mDentistNumber.setText(doctor.getContactNo());
                dentistID = doctor.getDoctorId();
            } else {
                mDentistName.setText("NO DENTIST");
                mDentistNumber.setText("");
            }
            mHospitalName.setText(hospital.getHospitalName());
            mHospitalAddress.setText("View Hospital In Google Maps");
            mContactNumber.setText(hospital.getHospitalHMOContactNumber());
        }
    }
}
