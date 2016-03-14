package com.jimbofer.hime.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jimbofer.hime.constants.Constants;
import com.jimbofer.hime.R;
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
    private String username, role;

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
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        // TODO: Perform logic operations here..

        String name = getArguments().getString(Constants.PARSE_LASTNAME_KEY) + ", " + getArguments().getString(Constants.PARSE_FIRSTNAME_KEY);
        String patientID = getArguments().getString(Constants.PARSE_PATIENTID_KEY);
        String birthday = getArguments().getString(Constants.PARSE_BIRTHDAY_KEY);
        String address = getArguments().getString(Constants.PARSE_ADDRESS_KEY);
        String gender = getArguments().getString(Constants.PARSE_GENDER_KEY);
        String number = getArguments().getString(Constants.PARSE_CONTACTNUM_KEY);
        tvPatientsName.setText(name);
        tvPatientsID.setText(patientID);
        tvPatientBirthday.setText(birthday);
        tvPatientAddress.setText(address);
        tvPatientGender.setText(gender);
        tvPatientContact.setText(number);
    }
}
