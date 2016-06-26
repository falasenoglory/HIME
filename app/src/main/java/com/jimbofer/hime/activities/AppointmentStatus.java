package com.jimbofer.hime.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jimbofer.hime.ParseUtils.ParseAppointments;
import com.jimbofer.hime.R;
import com.jimbofer.hime.fragments.ListViewFragmentAppointment;
import com.jimbofer.hime.model.Appointments;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class AppointmentStatus extends AppCompatActivity {

    private TextView mTvPatName;
    private TextView mTvAppTime;
    private TextView mTvAppDate;
    private TextView mTvStatus;
    private Button btnAccept;
    private Button btnIgnore;
    public String appID,patID;
    public static String username;
    public static String date;
    public static String time;
    public static String status;
    public static String patid;
    public static String docid;
    public static String aydi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_status);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mTvPatName = (TextView) findViewById(R.id.AppPatientName);
        mTvAppDate = (TextView) findViewById(R.id.AppDate);
        mTvAppTime = (TextView) findViewById(R.id.AppTime);
        mTvStatus = (TextView) findViewById(R.id.AppStatus);
        btnAccept = (Button) findViewById(R.id.btnAccept);
        btnIgnore = (Button) findViewById(R.id.btnIgnore);
        Intent i = getIntent();
        username = i.getStringExtra("username");
       appID = i.getStringExtra("appID");
        patID=i.getStringExtra("patID");
        List<ParseObject> list = new ArrayList<>();

        Appointments appt = null;
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Appointment");
        query.whereEqualTo("AppointmentID", appID);
        try {
            list = query.find();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (ParseObject obj : list) {
//            appt = new Appointments(obj.getString("AppointmentID"),obj.getString("AppointmentDate"),obj.getString("PatientID"),obj.getString("DoctorID"),obj.getString("AppointmentTime"),obj.getString("Status"));
            aydi = obj.getObjectId();
        }

        ParseQuery<ParseObject> query3= new ParseQuery<ParseObject>("Patient");
        query3.whereEqualTo("PatientID", patID);
        try {
            list = query3.find();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (ParseObject obj : list) {
            mTvPatName.setText(obj.getString("firstName") + "," + obj.getString("lastName"));
        }

        if (appt != null) {
            mTvAppDate.setText(appt.getAppointmentDate());
            mTvAppTime.setText(appt.getAppointmentTime());
            mTvStatus.setText(appt.getStatus());


           date = mTvAppDate.getText().toString();
           time = mTvAppTime.getText().toString();
           status = mTvStatus.getText().toString();
           patid = appt.getAppointmentPatientID();
           docid = appt.getAppointmentDoctorID();
        }

//        btnAccept.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v)
//            {
//                ParseAppointments.deleteAppointment(aydi);
//                ParseAppointments.addAppointment2(appID, date, time, "Accepted", patid, docid);
//                Intent backactivity = new Intent(AppointmentStatus.this,ViewAppointments.class);
//                backactivity.putExtra("username",username);
//                startActivity(backactivity);
//            }
//        });
        btnIgnore.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Intent backactivity = new Intent(AppointmentStatus.this,ViewAppointments.class);
                backactivity.putExtra("username",username);
                startActivity(backactivity);
            }
        });
    }
}
