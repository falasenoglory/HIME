package com.jimbofer.hime.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.jimbofer.hime.R;
import com.jimbofer.hime.fragments.ListViewFragmentAppointment;

/**
 * Created by Christian on 3/14/2016.
 */
public class ViewAppointments extends AppCompatActivity {
    private ListViewFragmentAppointment mListViewFragment;
    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_patients);

        Intent intent= getIntent();
        String username = intent.getStringExtra("username");
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        mListViewFragment = ListViewFragmentAppointment.newInstance();
        Bundle bundle = new Bundle();
        bundle.putString("doctorUsername", username);
        mListViewFragment.setArguments(bundle);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, mListViewFragment)
                .commit();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        this.menu = menu;

//        if (position == -1) {
//            menu.getItem(0).setIcon(getResources().getDrawable(R.drawable.ic_done));
//            menu.getItem(1).setVisible(false);
//            // mi.setIcon(R.drawable.ic_done);
//        }

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        if(item.getItemId()== R.id.action_edit)
        {
        }


        return super.onOptionsItemSelected(item);
    }

}
