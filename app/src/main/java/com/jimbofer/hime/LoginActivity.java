package com.jimbofer.hime;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;

import static android.Manifest.permission.READ_CONTACTS;


public class LoginActivity extends AppCompatActivity {

    private Button btn_login;
    String username;
    String role;
    String password;
    EditText et_username;
    EditText et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        et_username = (EditText) findViewById(R.id.AccountID);
        et_password = (EditText) findViewById(R.id.password);

        btn_login = (Button) findViewById(R.id.login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = et_username.getText().toString();
                password = et_password.getText().toString();
                ParseUser.logInInBackground(username, password, new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {

                        if (user!=null){
                            role=user.getString("Role");
                            if(role.equals("Doctor")) {
                                Intent intent = new Intent(LoginActivity.this, Doctor_Profile.class);//change activity
                                startActivity(intent);
                                finish();
                            }
                            if(role.equals("Patient")) {
                                Intent intent = new Intent(LoginActivity.this, Patient_Profile.class);//change activity
                                startActivity(intent);
                                finish();
                            }
                            if(role.equals("HospitalAdmin")) {
                                Intent intent = new Intent(LoginActivity.this, HospitalAdmin_Profile.class);//change activity
                                startActivity(intent);
                                finish();
                            }
                            if(role.equals("Insurance")) {
                                Intent intent = new Intent(LoginActivity.this, Insurance_Profile.class);//change activity
                                startActivity(intent);
                                finish();
                            }


                        }else{
                            Toast.makeText(getApplicationContext(), "This user does not exist. Please register.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }




}
