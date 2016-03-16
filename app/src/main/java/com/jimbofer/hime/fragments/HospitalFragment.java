package com.jimbofer.hime.fragments;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jimbofer.hime.ParseUtils.ParseDoctor;
import com.jimbofer.hime.ParseUtils.ParseHospitalAdmin;
import com.jimbofer.hime.ParseUtils.ParseTransaction;
import com.jimbofer.hime.R;
import com.jimbofer.hime.activities.PatientToHospitalActivity;
import com.jimbofer.hime.activities.TransactionDetails;
import com.jimbofer.hime.adapter.TransactionAdapter;
import com.jimbofer.hime.adapters.HospitalFragmentAdapter;
import com.jimbofer.hime.constants.Constants;
import com.jimbofer.hime.model.Doctor;
import com.jimbofer.hime.model.HospitalAdmin;
import com.jimbofer.hime.model.Transaction;
import com.jimbofer.hime.model.TransactionCardView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christian on 3/13/2016.
 */
public class HospitalFragment extends Fragment {


    static private View mView;
    static Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listview_doctor, container, false);
        mView = view;
        // TODO: Find all views here..
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        context = getActivity();
        new FetchData().execute();
        // TODO: Perform logic operations here..
    }


    public static class FetchData extends AsyncTask<Void, Void, Void> {
        HospitalAdmin hospital;
        List<Doctor> doctors;

        @Override
        public Void doInBackground(Void... params) {
            doctors = ParseDoctor.getAllDoctor();
            for (int x = 0; x < doctors.size(); x++) {
                hospital = ParseHospitalAdmin.getCertainHospitalAdminDetails(doctors.get(x).getHospitalId());
                doctors.get(x).setHospitalId(hospital.getHospitalName());
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void params) {
            ListView listView = (ListView) mView.findViewById(R.id.listView);
            HospitalFragmentAdapter hospitalFragmentAdapter = new HospitalFragmentAdapter(mView.getContext(), R.layout.cardview_transaction, doctors);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(context, PatientToHospitalActivity.class);
                    intent.putExtra("HospitalID", doctors.get(position).getHospitalId());
                    context.startActivity(intent);
                }
            });
            listView.setAdapter(hospitalFragmentAdapter);
        }
    }
}
