package com.jimbofer.hime;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.jimbofer.hime.fragments.ProfileFragment;
import com.jimbofer.hime.fragments.TransactionFragment;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private String username;
    private String role;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Intent intent = getIntent();
        role = intent.getStringExtra(Constants.ROLE_KEY);
        username = intent.getStringExtra(Constants.USERNAME_KEY);
        //this should show
        navigationView.setCheckedItem(R.id.nav_account);
//        if (role.equals(Constants.ROLE_PATIENT)) {
//            navigationView.setCheckedItem(R.id.nav_account);
//            Fragment fragment = new ProfileFragment();
//            Bundle bundle = new Bundle();
//            bundle.putString(Constants.ROLE_KEY, role);
//            bundle.putString(Constants.USERNAME_KEY, username);
//            fragment.setArguments(bundle);
//            FragmentManager fragmentManager = getFragmentManager();
//            fragmentManager.beginTransaction()
//                    .replace(R.id.fragmentContainer, fragment).commit();
//        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Fragment fragment = null;
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            fragment = new ProfileFragment();
            Bundle bundle = new Bundle();
            bundle.putString(Constants.ROLE_KEY, role);
            bundle.putString(Constants.USERNAME_KEY, username);
            fragment.setArguments(bundle);
        } else if (id == R.id.nav_account) {
            fragment = new ProfileFragment();
            Bundle bundle = new Bundle();
            bundle.putString(Constants.ROLE_KEY, role);
            bundle.putString(Constants.USERNAME_KEY, username);
            fragment.setArguments(bundle);
            Toast.makeText(getApplicationContext(), "Kayat", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_history) {
            //do something..
        } else if (id == R.id.nav_transaction) {
            fragment = new TransactionFragment();
        } else if (id == R.id.nav_hospital) {
            //do something
        } else if (id == R.id.nav_insurance) {
            //do something..
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, fragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
