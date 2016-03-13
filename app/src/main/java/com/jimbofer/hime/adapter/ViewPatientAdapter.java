package com.jimbofer.hime.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.jimbofer.hime.R;
import com.jimbofer.hime.model.Patient;

import java.util.List;

/**
 * Created by Shanyl Jimenez on 3/13/2016.
 */
public class ViewPatientAdapter extends ArrayAdapter<Patient> {

    private Context mContext;
    private int         mLayoutId;
    private List<Patient> mPatients;

    public ViewPatientAdapter(Context context, int resource, List<Patient> patients) {
        super(context, resource, patients);

        mContext = context;
        mLayoutId = resource;
        mPatients = patients;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            // Inflate the layout
            convertView = LayoutInflater.from(mContext).inflate(mLayoutId, parent, false);

            // create the view holder
            viewHolder = new ViewHolder();
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.txtPatientName);
            viewHolder.txtID= (TextView) convertView.findViewById(R.id.txtID);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Set the movie data
        Patient pa = mPatients.get(position);

        if (pa != null) {

            if (viewHolder.txtName != null) {
                viewHolder.txtName.setText(pa.getLastName()+", " +pa.getFirstName() +" ");
            }
            if (viewHolder.txtID != null) {
                viewHolder.txtID.setText(pa.getPatientID());
            }
        }

        return convertView;
    }

    private static class ViewHolder {
        public TextView  txtName;
        public TextView  txtID;
    }


}
