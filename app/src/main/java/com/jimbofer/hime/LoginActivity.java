package com.jimbofer.hime;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;


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
//                ParseUser.logInInBackground(username, password, new LogInCallback() {
//                    @Override
//                    public void done(ParseUser user, ParseException e) {

//                        if (user!=null){
//                            role=user.getString("Role");
                            if(username.equals("Doctor")) {
                                Intent intent = new Intent(LoginActivity.this,HomeActivity.class);//change activity
                                startActivity(intent);
                                finish();
                            }
                            else if(username.equals("Patient")) {
                                Intent intent = new Intent(LoginActivity.this,HomeActivity.class);//change activity
                                startActivity(intent);
                                finish();
                            }
                            else if(username.equals("HospitalAdmin")) {
                                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);//change activity
                                startActivity(intent);
                                finish();
                            }
                            else if(username.equals("Insurance")) {
                                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);//change activity
                                startActivity(intent);
                                finish();
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(), "This user does not exist. Please register.", Toast.LENGTH_SHORT).show();
                            }


//                        }else{
//                            Toast.makeText(getApplicationContext(), "This user does not exist. Please register.", Toast.LENGTH_SHORT).show();
//                        }
                    }
//                });
//
//            }
        });
    }




}
