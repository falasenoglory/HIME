package com.jimbofer.hime.main_activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jimbofer.hime.R;
import com.jimbofer.hime.constants.Constants;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;


public class LoginActivity extends Activity {

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

        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "aj8ntnHqK73s2LxmkWnPa9yJdPazzVg2DZj9QQ6f", "CbKfkP6JoRu5UvoXUeQMWkdqA6GKSPpWm38KmSsd");

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

                        if (user != null && e == null) {
                            String role = user.getString("Role");
                            if (role.equals(Constants.ROLE_PATIENT_KEY)) {
                                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);//change activity
                                intent.putExtra(Constants.USERNAME_KEY,username);
                                intent.putExtra(Constants.ROLE_KEY, role);
                                startActivity(intent);
                                finish();
                            }
                            if (role.equals(Constants.ROLE_DOCTOR_KEY)) {
                                Intent intent = new Intent(LoginActivity.this, DoctorActivity.class);//change activity
                                intent.putExtra(Constants.USERNAME_KEY,username);
                                intent.putExtra(Constants.ROLE_KEY, role);
                                startActivity(intent);
                                finish();
                            }
                            if (username.equals("HospitalAdmin")) {
                                Intent intent = new Intent(LoginActivity.this, InsuranceAdminProfile.class);//change activity
                                startActivity(intent);
                                finish();
                            }
                            if (username.equals("Insurance")) {
                                Intent intent = new Intent(LoginActivity.this, InsuranceAdminProfile.class);//change activity
                                intent.putExtra("username",username);
                                intent.putExtra("role", role);
                                startActivity(intent);
                                finish();
                            }
                        } else if (user == null) {
                            Toast.makeText(getApplicationContext(), "Error in log-in. Username and Password did not match.", Toast.LENGTH_SHORT).show();
                        }


//                        }else{
//                            Toast.makeText(getApplicationContext(), "This user does not exist. Please register.", Toast.LENGTH_SHORT).show();
//                        }
                    }
                });

            }
        });
    }
}