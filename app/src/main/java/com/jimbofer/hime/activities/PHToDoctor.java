package com.jimbofer.hime.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.jimbofer.hime.R;
import com.jimbofer.hime.fragments.AskReferralFragment;

/**
 * Created by Eugene Boholst on 3/16/2016.
 */
public class PHToDoctor extends AppCompatActivity {

    private Button mButton;
    private Button mButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phtodoctor);

        mButton = (Button) findViewById(R.id.firstButton);
        mButton2 = (Button) findViewById(R.id.secondButton);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //set appointment
            }
        });


        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new AskReferralFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, fragment).commit();
                //ask referral
            }
        });
    }
}
