package com.jimbofer.hime.adapters;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.jimbofer.hime.ParseUtils.ParseDoctor;
import com.jimbofer.hime.ParseUtils.ParseHospitalAdmin;
import com.jimbofer.hime.R;
import com.jimbofer.hime.activities.TransactionDetails;
import com.jimbofer.hime.model.Doctor;
import com.jimbofer.hime.model.HospitalAdmin;
import com.jimbofer.hime.model.Transaction;
import com.jimbofer.hime.model.TransactionCardView;

import java.util.List;

/**
 * Created by Eugene Boholst on 3/13/2016.
 */
public class TransactionAdapter extends ArrayAdapter<TransactionCardView> {

    private Context mContext;
    private int mLayoutId;
    private static List<TransactionCardView> transactions;
    private static TransactionHolder transactionHolder;

    public TransactionAdapter(Context context, int resource, List<TransactionCardView> objects) {
        super(context, resource, objects);
        mContext = context;
        mLayoutId = resource;
        transactions = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(mLayoutId, parent, false);
            transactionHolder = new TransactionHolder();
            transactionHolder.tvDate = (TextView) convertView.findViewById(R.id.day);
            transactionHolder.tvMonth = (TextView) convertView.findViewById(R.id.month);
            transactionHolder.tvDoctorName = (TextView) convertView.findViewById(R.id.doctorName);
            transactionHolder.tvHospitalName = (TextView) convertView.findViewById(R.id.hospitalName);
            convertView.setTag(transactionHolder);
        } else {
            transactionHolder = (TransactionHolder) convertView.getTag();
        }
        if (transactions.get(position) != null) {
            transactionHolder.tvDate.setText(transactions.get(position).getDay());
            transactionHolder.tvMonth.setText(transactions.get(position).getYear());
            transactionHolder.tvHospitalName.setText(transactions.get(position).getHospitalName());
            transactionHolder.tvDoctorName.setText(transactions.get(position).getDoctorName());
        }
        return convertView;
    }

    public class TransactionHolder {
        private TextView tvDate;
        private TextView tvMonth;
        private TextView tvHospitalName;
        private TextView tvDoctorName;
    }
}
