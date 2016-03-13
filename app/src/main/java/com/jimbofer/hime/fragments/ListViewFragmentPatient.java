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

import com.jimbofer.hime.R;
import com.jimbofer.hime.activities.ProfileActivity;
import com.jimbofer.hime.adapters.ViewPatientAdapter;
import com.jimbofer.hime.model.Patient;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shanyl Jimenez on 3/13/2016.
 */
public class ListViewFragmentPatient extends Fragment implements AdapterView.OnItemClickListener{

    private ListView mListView;
    private List<Patient> Lpatient= new ArrayList<>();

    public static ListViewFragmentPatient newInstance() {
        return new ListViewFragmentPatient();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listviewpatients, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        // find all the views
        mListView = (ListView) view.findViewById(R.id.listView);

        Lpatient.clear();
        /////////// GET PATIENT DATAS ///////////////////////////////////////////
                    ParseQuery<ParseObject> query = ParseQuery.getQuery("Patient");
                    query.orderByDescending("createdAt");
                    query.findInBackground(new FindCallback<ParseObject>() {
                            @Override
                            public void done(List<ParseObject> markers, ParseException e) {
                                if (e == null) {
                                    Patient pat = null;
                                    ParseObject obj;
                                    for (int i = 0; i < markers.size(); i++) {
                                        obj = markers.get(i);
                                        pat = new Patient(obj.getString("objectId"), obj.getString("Insurance_ID"), obj.getString("PatientID"), obj.getString("firstName"), obj.getString("lastName"), obj.getString("MiddleInitial"), obj.getString("address"), obj.getString("birthday"), obj.getString("medicalHistory"), obj.getString("gender"), obj.getString("patientRemainingInsuranceBalance"), obj.getString("contactNo"));
                                        Log.d("shan", "pat: " + pat.toString());
                                        Lpatient.add(pat);
                                        Log.d("shan", Lpatient.get(Lpatient.size() - 1).getFirstName());
                                    }

                                    Log.d("shan", Lpatient.get(Lpatient.size() - 1).getFirstName());
                                    // create a new instance of adapter
                                    ViewPatientAdapter adapter = new ViewPatientAdapter(getActivity(),
                                            R.layout.item_patient, Lpatient);

                                    Log.d("shan", "adapter ni: " + Lpatient.get(Lpatient.size() - 1).getFirstName());

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

            Intent intent = new Intent(getActivity(), ProfileActivity.class);
            intent.putExtra("Position", position);
            startActivity(intent);

    }

}
