package com.jimbofer.hime.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jimbofer.hime.ParseUtils.ParseDoctor;
import com.jimbofer.hime.ParseUtils.ParseHospitalAdmin;
import com.jimbofer.hime.ParseUtils.ParseTransaction;
import com.jimbofer.hime.R;
import com.jimbofer.hime.activities.TransactionDetails;
import com.jimbofer.hime.adapter.TransactionAdapter;
import com.jimbofer.hime.constants.Constants;
import com.jimbofer.hime.model.Doctor;
import com.jimbofer.hime.model.HospitalAdmin;
import com.jimbofer.hime.model.Transaction;
import com.jimbofer.hime.model.TransactionCardView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eugene Boholst on 2/8/2016.
 */
public class TransactionFragment extends Fragment {
    static private View mView;
    static private List<Transaction> transactions;
    static String patientID;
    static Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.patient_transaction_fragment, container, false);
        mView = view;
        // TODO: Find all views here..
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        patientID = getArguments().getString(Constants.PARSE_PATIENTID_KEY);
        context = getActivity();
        new FetchData().execute();
        // TODO: Perform logic operations here..
    }


    public static class FetchData extends AsyncTask<String, Void, List<TransactionCardView>> {
        Doctor doctor;
        HospitalAdmin hospital;
        List<Transaction> transactions;
        List<TransactionCardView> transactionCardViews = new ArrayList<>();

        @Override
        public List<TransactionCardView> doInBackground(String... params) {
            transactions = ParseTransaction.getAllTransactionOfPatient(patientID);
            for (int x = 0; x < transactions.size(); x++) {
                doctor = ParseDoctor.getCertainDoctorDetails(transactions.get(x).getDoctorID());
                hospital = ParseHospitalAdmin.getCertainHospitalAdminDetails(transactions.get(x).getHospitalID());
                String date = transactions.get(x).getTransactionDate();
                String day = date.split("/")[1];
                String month = date.split("/")[0];
                transactionCardViews.add(new TransactionCardView(transactions.get(x).getTransactionID(), day, month, hospital.getHospitalName(), doctor.getLastname() + ", " + doctor.getFirstname()));
            }
            return transactionCardViews;
        }

        @Override
        protected void onPostExecute(List<TransactionCardView> parseTransactions) {
            ListView listView = (ListView) mView.findViewById(R.id.listView);
            TransactionAdapter transactionAdapter = new TransactionAdapter(mView.getContext(), R.layout.cardview_transaction, parseTransactions);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(context, TransactionDetails.class);
                    intent.putExtra("TransactionID", transactions.get(position).getTransactionID());
                    intent.putExtra("DoctorName", transactionCardViews.get(position).getDoctorName());
                    intent.putExtra("HospitalName", transactionCardViews.get(position).getHospitalName());
                    context.startActivity(intent);
                }
            });
            listView.setAdapter(transactionAdapter);
        }
    }
}
