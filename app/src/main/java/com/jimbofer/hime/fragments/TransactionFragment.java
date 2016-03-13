package com.jimbofer.hime.fragments;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.jimbofer.hime.ParseUtils.ParseTransaction;
import com.jimbofer.hime.R;
import com.jimbofer.hime.adapters.TransactionAdapter;
import com.jimbofer.hime.model.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eugene Boholst on 2/8/2016.
 */
public class TransactionFragment extends Fragment{
    static private View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.patient_transaction_fragment, container, false);
        mView = view;
        // TODO: Find all views here..
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        new FetchData().execute();
        // TODO: Perform logic operations here..
    }


    public static class FetchData extends AsyncTask<Void, Void, List<Transaction>> {
        @Override
        public List<Transaction> doInBackground(Void... params) {
            return ParseTransaction.getTransactions();
        }

        @Override
        protected void onPostExecute(List<Transaction> parseTransactions) {
            ListView listView = (ListView) mView.findViewById(R.id.listView);
            TransactionAdapter transactionAdapter = new TransactionAdapter(mView.getContext(), R.layout.cardview_transaction, parseTransactions);
            listView.setAdapter(transactionAdapter);
        }
    }

}
