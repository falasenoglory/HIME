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
public class TransactionFragment extends Fragment {
    static ArrayList<Transaction> pastTransactions;
    static private View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.patient_transaction_fragment, container, false);
        mView = view;
//        pastTransactions = new ArrayList<>();
//
//        final ListView listView = (ListView) view.findViewById(R.id.listView);
//        ParseQuery<ParseObject> query = ParseQuery.getQuery("Transaction");
//        query.findInBackground(new FindCallback<ParseObject>() {
//            @Override
//            public void done(List<ParseObject> markers, ParseException e) {
//                if (e == null) {
//
//                    for (ParseObject obj : markers) {
//                        Transaction medhis = new Transaction(obj.getString("objectId"), obj.getString("transactionID"), obj.getString("patientID"), obj.getString("insuranceID"), obj.getString("hospitalID"), obj.getString("DoctorID"), obj.getString("transactionType"), obj.getString("transactionDescription"), obj.getString("transactionDate"), obj.getString("transactionPrice"));
//                        String objid = obj.getString("objectId");
//                        String tranid = obj.getString("transactionID");
//                        String patid = obj.getString("patientID");
//                        String insid = obj.getString("insuranceID");
//                        String hopid = obj.getString("hospitalID");
//                        String docid = obj.getString("DoctorID");
//                        String transtype = obj.getString("transactionType");
//                        String trandesc = obj.getString("transactionDescription");
//                        String transdate = obj.getString("transactionDate");
//                        String transPrice = obj.getString("transactionPrice");
//                        Transaction transs;
//                        transs = new Transaction(objid, tranid, patid, insid, hopid, docid, transtype, trandesc, transdate, transPrice);
//                        pastTransactions.add(medhis);
//                    }
//
//                    TransactionAdapter transactionAdapter = new TransactionAdapter(view.getContext(), R.layout.cardview_transaction, pastTransactions);
//                    listView.setAdapter(transactionAdapter);
//                } else {
//                    Log.d("Boholst", "EXCEPTION!");
//                }
//            }
//        });
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
