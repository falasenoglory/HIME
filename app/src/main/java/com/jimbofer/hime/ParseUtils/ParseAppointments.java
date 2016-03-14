package com.jimbofer.hime.ParseUtils;

import android.util.Log;

import com.jimbofer.hime.model.Appointments;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christian on 3/14/2016.
 */
public class ParseAppointments {

    public static Appointments appt;

    public static List<Appointments> getAllAppointments(){
        List<ParseObject> list = new ArrayList<>();
        List<Appointments> parseAppointment = new ArrayList<>();

        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Appointment");
        try {
            list = query.find();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (ParseObject obj : list) {
            Appointments appt = new Appointments(obj.getString("AppointmentID"),obj.getString("AppointmentDate"),obj.getString("PatientID"),obj.getString("DoctorID"),obj.getString("AppointmentTime"),obj.getString("Status"));
            parseAppointment.add(appt);
        }
        return parseAppointment;
    }
    public static Appointments getCertainAppointmentDetails(String objID){

        List<ParseObject> list = new ArrayList<>();

        Appointments appt = null;
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Appointment");
        query.whereEqualTo("objectId", objID);
        try {
            list = query.find();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (ParseObject obj : list) {
            appt = new Appointments(obj.getString("AppointmentID"),obj.getString("AppointmentDate"),obj.getString("PatientID"),obj.getString("DoctorID"),obj.getString("AppointmentTime"),obj.getString("Status"));

        }
        return appt;
    }
    public static int ListSize(){
        List<ParseObject> list = new ArrayList<>();
        List<Appointments> parseAppointment = new ArrayList<>();

        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Appointment");
        try {
            list = query.find();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (ParseObject obj : list) {
            Appointments appt = new Appointments(obj.getString("AppointmentID"),obj.getString("AppointmentDate"),obj.getString("PatientID"),obj.getString("DoctorID"),obj.getString("AppointmentTime"),obj.getString("Status"));
            parseAppointment.add(appt);
        }
        return Integer.parseInt(parseAppointment.get(parseAppointment.size() - 1).getAppointmentID());

    }
    public void addAppointment(String appID,String appDate,String patid,String docid,String status,String apptTime){
        int apid = ListSize()+1;
        ParseObject storyActivity = new ParseObject("Appointment");
        storyActivity.put("AppointmentID", apid);
        storyActivity.put("AppointmentDate",appDate);
        storyActivity.put("PatientID",patid);
        storyActivity.put("DoctorID",docid);
        storyActivity.put("Status",status);
        storyActivity.put("AppointmentTime",apptTime);

        storyActivity.saveInBackground(new SaveCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    // your object is successfully created.
                } else {
                    //error occurred
                    Log.d("Error", "Nothing added , Exception " + e);
                }
            }
        });
    }
    public void deleteAppointment(String objID){
        ParseQuery<ParseObject> query2 = ParseQuery.getQuery("Appointment");
        query2.whereEqualTo("objectId", objID);
        query2.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, ParseException e) {
                if (e == null) {

                    for (ParseObject obj : list) {

                        try {
                            obj.delete();

                        } catch (ParseException e1) {
                            e1.printStackTrace();
                        }


                    }


                } else {

                }
            }
        });
    }
}
