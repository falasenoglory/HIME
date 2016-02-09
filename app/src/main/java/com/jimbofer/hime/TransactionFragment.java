package com.jimbofer.hime;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Eugene Boholst on 2/8/2016.
 */
public class TransactionFragment extends Fragment {
    private TextView mDay;
    private TextView mMonth;
    private TextView mHospital;
    private TextView mDoctor;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.patient_transaction_fragment, container, false);
        // TODO: Find all views here..
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        // TODO: Perform logic operations here..
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
    }
}
