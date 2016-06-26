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
import com.jimbofer.hime.activities.AppointmentStatus;
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
    public static String doctorIDf;
    public static String username;
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

        List<String> doctorID;
        Log.d("Chan","Username: "+getArguments().getString("doctorUsername"));
        username = getArguments().getString("doctorUsername");
        List<ParseObject> list2 = new ArrayList<>();
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Doctor");
        query.whereEqualTo("Doctor", username);
        try {
            list2 = query.find();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (ParseObject obj : list2) {
            doctorIDf = obj.getString("doctorID");
            Log.d("chan", "Doctor ID :  "+String.valueOf(doctorIDf));
        }


        List<ParseObject> list = new ArrayList<>();
        ParseQuery<ParseObject> query2= ParseQuery.getQuery("Appointment");
        query2.whereEqualTo("DoctorID", doctorIDf);
        try {
            list = query2.find();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (ParseObject obj : list) {
//            Appointments appt = new Appointments(obj.getString("AppointmentID"), obj.getString("AppointmentDate"), obj.getString("PatientID"), obj.getString("DoctorID"), obj.getString("AppointmentTime"), obj.getString("Status"));

//            Lappointment.add(appt);
            Log.d("chan", "Status: " + obj.getString("Status"));
            Log.d("chan", "Status: " + obj.getString("Status"));
        }

                    Log.d("chan","Appointment size : "+String.valueOf(Lappointment.size()));
                    // create a new instance of adapter
                    ViewAppointmentRequest adapter = new ViewAppointmentRequest(getActivity(),
                            R.layout.item_appointment, Lappointment);


                    // set the adapter
                    mListView.setAdapter(adapter);

                    // set item click listener


                    // handle Parse Exception here



        // set item click listener
        mListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
       Lappointment.get(position).getAppointmentID();
            Intent i = new Intent(getContext(), AppointmentStatus.class);
            i.putExtra("username",username);
        i.putExtra("patID",Lappointment.get(position).getAppointmentPatientID());
            i.putExtra("appID", Lappointment.get(position).getAppointmentID());
            startActivity(i);


    }
}
