package com.jimbofer.hime.activities;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.jimbofer.hime.ParseUtils.ParseAppointments;
import com.jimbofer.hime.R;
import com.jimbofer.hime.model.Appointments;

import java.util.List;

/**
 * Created by Eugene Boholst on 3/12/2016.
 */
public class DoctorActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mContext = this;


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.getMenu().clear();
        navigationView.inflateMenu(R.menu.activity_doctor_drawer);
        navigationView.setNavigationItemSelectedListener(this);

        new FetchAppointments().execute();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        return false;
    }


    public class FetchAppointments extends AsyncTask<Void, Void, Void> {

        List<Appointments> appointments;

        @Override
        protected Void doInBackground(Void... params) {
            appointments = ParseAppointments.getDoctorPendingAppointments("D1006");
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            if(appointments.size() > 0){
                NotificationCompat.Builder mBuilder =
                        new NotificationCompat.Builder(mContext)
                                .setSmallIcon(R.mipmap.ic_launcher)
                                .setTicker("You have an appointment request")
                                .setContentTitle("You've got " + appointments.size() + " request!")
                                .setContentText("View in Appointments!");
                NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                // id allows you to update the notification later on.
                int id = 001;
                mNotificationManager.notify(id, mBuilder.build());
            }
        }
    }

}
