package com.jimbofer.hime;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

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
            ParseQuery<ParseObject> query2 = ParseQuery.getQuery(Constants.ROLE_PATIENT);
            query2.whereEqualTo(Constants.USERNAME_KEY, username);
            query2.findInBackground(new FindCallback<ParseObject>() {
                @Override
                public void done(List<ParseObject> list, ParseException e) {
                    if (e == null) {
                        for (ParseObject obj : list) {
                            String name = obj.getString(Constants.PARSE_LASTNAME_KEY)+", "+obj.getString(Constants.PARSE_FIRSTNAME_KEY);
                            tvPatientsName.setText(name);
                            tvPatientsID.setText(obj.getString(Constants.PARSE_PATIENTID_KEY));
                            tvPatientBirthday.setText(obj.getString(Constants.PARSE_BIRTHDAY_KEY));
                            tvPatientAddress.setText(obj.getString(Constants.PARSE_ADDRESS_KEY));
                            tvPatientGender.setText(obj.getString(Constants.PARSE_GENDER_KEY));
                            tvPatientContact.setText(obj.getString(Constants.PARSE_CONTACTNUM_KEY));
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
