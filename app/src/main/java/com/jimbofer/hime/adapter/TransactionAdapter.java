package com.jimbofer.hime.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.jimbofer.hime.R;
import com.jimbofer.hime.model.Transaction;

import java.util.List;

/**
 * Created by Eugene Boholst on 3/13/2016.
 */
public class TransactionAdapter extends ArrayAdapter<Transaction> {

    private Context mContext;
    private int mLayoutId;
    private static List<Transaction> transactions;
    private static int position;

    public TransactionAdapter(Context context, int resource, List<Transaction> objects) {
        super(context, resource, objects);
        mContext = context;
        mLayoutId = resource;
        transactions = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TransactionHolder transactionHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(mLayoutId, parent, false);
            transactionHolder= new TransactionHolder();
            transactionHolder.tvDate = (TextView) convertView.findViewById(R.id.day);
            transactionHolder.tvMonth = (TextView) convertView.findViewById(R.id.month);
            transactionHolder.tvDoctorName = (TextView) convertView.findViewById(R.id.doctorName);
            transactionHolder.tvHospitalName = (TextView) convertView.findViewById(R.id.hospitalName);
            convertView.setTag(transactionHolder);
        } else {
            transactionHolder = (TransactionHolder) convertView.getTag();
        }

        Transaction transaction = transactions.get(position);

        if(transaction != null){
            String date = transaction.getTransactionDate();
            String day = date.split("/")[1];
            String month = date.split("/")[0];
            transactionHolder.tvDate.setText(day);
            transactionHolder.tvMonth.setText(month);
            this.position = position;
//            Doctor doctor = ParseDoctor.getCertainDoctorDetails(transaction.getDoctorID());
//            transactionHolder.tvDoctorName.setText(doctor.getLastname() + ", " + doctor.getFirstname());
//            HospitalAdmin hospital = ParseHospitalAdmin.getCertainHospitalAdminDetails(transaction.getHospitalID());
//            transactionHolder.tvHospitalName.setText(hospital.getHospitalName());
        }
        return convertView;
    }

    public static class TransactionHolder{
        private TextView tvDate;
        private TextView tvMonth;
        private TextView tvHospitalName;
        private TextView tvDoctorName;
    }
}
