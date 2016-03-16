package com.jimbofer.hime.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.jimbofer.hime.ParseUtils.ParseTransaction;
import com.jimbofer.hime.R;
import com.jimbofer.hime.model.Doctor;
import com.jimbofer.hime.model.HospitalAdmin;
import com.jimbofer.hime.model.Transaction;

import java.util.List;

/**
 * Created by Eugene Boholst on 3/14/2016.
 */
public class TransactionDetails extends AppCompatActivity {

    private static TextView mPatientID;
    private static TextView mHospitalName;
    private static TextView mDoctorName;
    private static TextView mDescription;
    private static TextView mDate;
    private static TextView mPrice;
    private Intent intent;
    private static String transactionID;
    private static String mDName;
    private static String mHName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transaction_details);
        mPatientID = (TextView) findViewById(R.id.patientID);
        mHospitalName = (TextView) findViewById(R.id.hospitalID2);
        mDoctorName = (TextView) findViewById(R.id.doctorID);
        mDescription = (TextView) findViewById(R.id.description);
        mDate = (TextView) findViewById(R.id.transactionDate2);
        mPrice = (TextView) findViewById(R.id.patientTransactionPrice);

        intent = getIntent();
        transactionID = intent.getStringExtra("TransactionID");
        mDName = intent.getStringExtra("DoctorName");
        mHName = intent.getStringExtra("HospitalName");
        new PerformTransactionTask().execute();
    }

    public static class PerformTransactionTask extends AsyncTask<Void, Void, Transaction> {

        Doctor doctor;
        HospitalAdmin hospital;
        @Override
        protected Transaction doInBackground(Void... params) {
            return ParseTransaction.getCertainTransactionDetails(transactionID);
        }

        @Override
        protected void onPostExecute(Transaction transaction) {
            Log.d("Boholst", transaction.toString());
            mPatientID.setText(transaction.getPatientID());
            mHospitalName.setText(mHName);
            mDoctorName.setText(mDName);
            mDescription.setText(transaction.getTransactionDescription());
            mDate.setText(transaction.getTransactionDate());
            mPrice.setText(transaction.getTransactionPrice());
        }
    }
}
