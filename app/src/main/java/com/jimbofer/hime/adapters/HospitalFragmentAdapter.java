package com.jimbofer.hime.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.jimbofer.hime.R;
import com.jimbofer.hime.model.Doctor;
import com.jimbofer.hime.model.HospitalAdmin;
import com.jimbofer.hime.model.TransactionCardView;

import java.util.List;

/**
 * Created by Eugene Boholst on 3/16/2016.
 */
public class HospitalFragmentAdapter extends ArrayAdapter<HospitalAdmin> {

    private Context mContext;
    private int mLayoutId;
    private static List<HospitalAdmin> hospitals;
    private static TransactionHolder transactionHolder;

    public HospitalFragmentAdapter(Context context, int resource, List<HospitalAdmin> hospitals) {
        super(context, resource, hospitals);
        mContext = context;
        mLayoutId = resource;
        this.hospitals = hospitals;
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
        if (hospitals.get(position) != null) {
            transactionHolder.tvDate.setText("");
            transactionHolder.tvMonth.setText("");
            transactionHolder.tvHospitalName.setText(hospitals.get(position).getHospitalName());
            transactionHolder.tvDoctorName.setText(hospitals.get(position).getHospitalHMOContactNumber());
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
