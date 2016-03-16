package com.jimbofer.hime.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jimbofer.hime.R;

/**
 * Created by Eugene Boholst on 3/16/2016.
 */
public class AskReferralFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.phdoctor_ask_referral, container, false);
        // TODO: Find all views here..
        return view;
    }
}
