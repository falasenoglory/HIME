package com.jimbofer.hime.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.jimbofer.hime.R;
import com.jimbofer.hime.adapters.ViewAppointmentRequest;
import com.jimbofer.hime.model.Appointments;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christian on 3/14/2016.
 */
public class ListViewFragmentAppointment extends Fragment implements AdapterView.OnItemClickListener {
    private ListView mListView;
    public String[] doctorIDf = null;

    private List<Appointments> Lappointment= new ArrayList<>();

    public static ListViewFragmentAppointment newInstance() {
        return new ListViewFragmentAppointment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listview_appointment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        // find all the views
        mListView = (ListView) view.findViewById(R.id.listViewApp);

        Lappointment.clear();

        final String[] doctorID = {null};
        String username = getArguments().getString("doctorUsername");
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Doctor");
        query.whereEqualTo("Doctor", username);
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, ParseException e) {
                if (e == null) {

                    for (ParseObject obj : list) {
                        doctorID[0] = obj.getString("doctorID");
                    }


                } else {
                }
            }
        });

     doctorIDf = doctorID;


        ParseQuery<ParseObject> query2= ParseQuery.getQuery("Appointment");
        query2.whereEqualTo("DoctorID", doctorID[0]);
        query2.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> markers, ParseException e) {
                if (e == null) {

                    for (ParseObject obj : markers) {
                        Appointments appt = new Appointments(obj.getString("AppointmentID"),obj.getString("AppointmentDate"),obj.getString("PatientID"),obj.getString("DoctorID"),obj.getString("AppointmentTime"),obj.getString("Status"));
                        Lappointment.add(appt);
                    }

                    Log.d("shan", String.valueOf(Lappointment.size()));
                    // create a new instance of adapter
                    ViewAppointmentRequest adapter = new ViewAppointmentRequest(getActivity(),
                            R.layout.item_appointment, Lappointment);


                    // set the adapter
                    mListView.setAdapter(adapter);

                    // set item click listener

                } else {
                    // handle Parse Exception here
                    Log.d("shan", "error: " + e);
                }
            }
        });

        // set item click listener
        mListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


    }
}
