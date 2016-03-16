package com.jimbofer.hime.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.jimbofer.hime.R;
import com.jimbofer.hime.model.Doctor;
import com.jimbofer.hime.model.TransactionCardView;

import java.util.List;

/**
 * Created by Eugene Boholst on 3/16/2016.
 */
public class HospitalFragmentAdapter extends ArrayAdapter<Doctor> {

    private Context mContext;
    private int mLayoutId;
    private static List<Doctor> doctors;
    private static TransactionHolder transactionHolder;

    public HospitalFragmentAdapter(Context context, int resource, List<Doctor> objects) {
        super(context, resource, objects);
        mContext = context;
        mLayoutId = resource;
        doctors = objects;
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
        if (doctors.get(position) != null) {
            transactionHolder.tvDate.setText("");
            transactionHolder.tvMonth.setText("");
            transactionHolder.tvHospitalName.setText(doctors.get(position).getHospitalId());
            transactionHolder.tvDoctorName.setText("Dr. " + doctors.get(position).getFirstname() + " " + doctors.get(position).getLastname() + ", " + doctors.get(position).getSpecialization());
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
