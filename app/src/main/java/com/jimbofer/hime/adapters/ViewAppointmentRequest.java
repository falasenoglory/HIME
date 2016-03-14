package com.jimbofer.hime.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.jimbofer.hime.ParseUtils.ParseAppointments;
import com.jimbofer.hime.R;
import com.jimbofer.hime.model.Appointments;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Christian on 3/13/2016.
 */
public class ViewAppointmentRequest extends ArrayAdapter<Appointments> {

    private Context mContext;
    private int         mLayoutId;
    private List<Appointments> mAppointments;

    public ViewAppointmentRequest(Context context, int resource, List<Appointments> appointment) {
        super(context, resource, appointment);

        mContext = context;
        mLayoutId = resource;
        mAppointments = appointment;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;

        if (convertView == null) {
            // Inflate the layout
            convertView = LayoutInflater.from(mContext).inflate(mLayoutId, parent, false);

            // create the view holder
            viewHolder = new ViewHolder();

            viewHolder.txtDate = (TextView) convertView.findViewById(R.id.dayA);
            viewHolder.txtMonth = (TextView) convertView.findViewById(R.id.monthA);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.PatientName2);
            viewHolder.txtStatus= (TextView) convertView.findViewById(R.id.Status);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Appointments appt = mAppointments.get(position);

        if(appt != null) {
            String date = appt.getAppointmentDate();
            String day = date.split("/")[1];
            String month = date.split("/")[0];
            viewHolder.txtDate.setText(day);
            viewHolder.txtMonth.setText(month);
            viewHolder.txtStatus.setText(appt.getStatus());
            String patientID = appt.getAppointmentPatientID();
            ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Patient");
            query.whereEqualTo("PatientID", patientID);
            query.findInBackground(new FindCallback<ParseObject>() {
                @Override
                public void done(List<ParseObject> list, ParseException e) {
                    if (e == null) {

                        for (ParseObject obj : list) {
                            viewHolder.txtName.setText(obj.getString("firstName") + "," + obj.getString("lastName"));
                        }


                    } else {
                    }
                }
            });

        }
        return convertView;
    }

    private static class ViewHolder {
        public TextView  txtName;
        public TextView  txtStatus;
        public TextView  txtDate;
        public TextView txtMonth;
    }



}
