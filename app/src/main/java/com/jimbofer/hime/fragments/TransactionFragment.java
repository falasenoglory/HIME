package com.jimbofer.hime.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jimbofer.hime.ParseUtils.ParsePatient;
import com.jimbofer.hime.ParseUtils.ParseTransaction;
import com.jimbofer.hime.R;
import com.jimbofer.hime.adapter.TransactionAdapter;
import com.jimbofer.hime.constants.Constants;
import com.jimbofer.hime.model.Patient;
import com.jimbofer.hime.model.Transaction;

import java.util.List;

/**
 * Created by Eugene Boholst on 2/8/2016.
 */
public class TransactionFragment extends Fragment implements AdapterView.OnItemClickListener{
    static private View mView;
    static private List<Transaction> transactions;
    static String patientID;

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
        patientID = getArguments().getString(Constants.PARSE_PATIENTID_KEY);
        new FetchData().execute();
        // TODO: Perform logic operations here..
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //do something..
        Fragment fragment = new TransactionDetails();
        Bundle bundle = new Bundle();
        bundle.putString("TransactionID", transactions.get(position).getTransactionID());
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment).commit();
    }


    public static class FetchData extends AsyncTask<Void, Void, List<Transaction>> {
        @Override
        public List<Transaction> doInBackground(Void... params) {
            return ParseTransaction.getAllTransactionOfPatient(patientID);
        }

        @Override
        protected void onPostExecute(List<Transaction> parseTransactions) {
            transactions = parseTransactions;
            ListView listView = (ListView) mView.findViewById(R.id.listView);
            TransactionAdapter transactionAdapter = new TransactionAdapter(mView.getContext(), R.layout.cardview_transaction, parseTransactions);
            listView.setAdapter(transactionAdapter);
        }
    }

}
