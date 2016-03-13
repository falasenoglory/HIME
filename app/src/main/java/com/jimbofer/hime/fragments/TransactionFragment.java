package com.jimbofer.hime.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.jimbofer.hime.ParseUtils.ParseTransaction;
import com.jimbofer.hime.R;
import com.jimbofer.hime.adapters.TransactionAdapter;
import com.jimbofer.hime.model.Transaction;

import java.util.List;

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

        //DIRI CHAN
//        ListView listView = (ListView)view.findViewById(R.id.listView);
//        List<Transaction> list = ParseTransaction.getAllTransaction();
//        TransactionAdapter transactionAdapter = new TransactionAdapter(view.getContext(), R.layout.cardview_transaction, list);
//        listView.setAdapter(transactionAdapter);

        // TODO: Find all views here..
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        // TODO: Perform logic operations here..
//        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
    }
}
