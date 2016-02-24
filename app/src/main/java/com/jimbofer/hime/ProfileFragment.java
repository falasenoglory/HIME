package com.jimbofer.hime;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Eugene Boholst on 2/10/2016.
 */
public class ProfileFragment extends Fragment {

    private TextView tvPatientsName;
    private TextView tvPatientsID;
    private TextView tvPatientBirthday;
    private TextView tvPatientAddress;
    private TextView tvPatientGender;
    private TextView tvPatientContact;
    private String username,role;
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_layout, container, false);
        // TODO: Find all views here..
        tvPatientsName = (TextView) view.findViewById(R.id.patientsName);
        tvPatientsID = (TextView) view.findViewById(R.id.patientID);
        tvPatientBirthday = (TextView) view.findViewById(R.id.patientBirthday);
        tvPatientAddress = (TextView) view.findViewById(R.id.patientAddress);
        tvPatientGender = (TextView) view.findViewById(R.id.patientGender);
        tvPatientContact = (TextView) view.findViewById(R.id.patientContactNumber);

        role = getArguments().getString(Constants.ROLE_KEY);
        username = getArguments().getString(Constants.USERNAME_KEY);


        if(role.equals(Constants.ROLE_PATIENT)) {
            ParseQuery<ParseObject> query2 = ParseQuery.getQuery("Patient");
            query2.whereEqualTo("Username", username);
            query2.findInBackground(new FindCallback<ParseObject>() {
                @Override
                public void done(List<ParseObject> list, ParseException e) {
                    if (e == null) {

                        for (ParseObject obj : list) {


                            tvPatientsName.setText(obj.getString("firstName")+""+obj.getString("lastName"));
                            tvPatientsID.setText(obj.getString("PatientID"));
                            tvPatientBirthday.setText(obj.getString("birthday"));
                            tvPatientAddress.setText(obj.getString("address"));
                            tvPatientGender.setText(obj.getString("gender"));
                            tvPatientContact.setText(obj.getString("contactNo"));
                        }


                    } else {
                        Log.d("role_patient error","e");

                    }
                }
            });
        }

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        // TODO: Perform logic operations here..
    }
}
