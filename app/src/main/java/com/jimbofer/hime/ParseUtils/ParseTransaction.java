package com.jimbofer.hime.ParseUtils;

import android.util.Log;

import com.jimbofer.hime.model.Transaction;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christian on 3/11/2016.
 */
public class ParseTransaction {
    public static ArrayList<Transaction> parseTransaction = new ArrayList<>();
    private OnDataPass dataPasser;
    public static Transaction tran;
    public static int size;

    public static ArrayList<Transaction> getAllTransaction() {
        final ArrayList<Transaction> dumLish = new ArrayList<>();
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Transaction");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> markers, ParseException e) {
                if (e == null) {

                    for (ParseObject obj : markers) {
                        Transaction medhis = new Transaction(obj.getString("objectId"), obj.getString("transactionID"), obj.getString("patientID"), obj.getString("insuranceID"), obj.getString("hospitalID"), obj.getString("DoctorID"), obj.getString("transactionType"), obj.getString("transactionDescription"), obj.getString("transactionDate"), obj.getString("transactionPrice"));
                        String objid = obj.getString("objectId");
                        String tranid = obj.getString("transactionID");
                        String patid = obj.getString("patientID");
                        String insid = obj.getString("insuranceID");
                        String hopid = obj.getString("hospitalID");
                        String docid = obj.getString("DoctorID");
                        String transtype = obj.getString("transactionType");
                        String trandesc = obj.getString("transactionDescription");
                        String transdate = obj.getString("transactionDate");
                        String transPrice = obj.getString("transactionPrice");
                        Transaction transs;
                        transs = new Transaction(objid, tranid, patid, insid, hopid, docid, transtype, trandesc, transdate, transPrice);
                        Log.d("Boholst", "lols");
                        parseTransaction.add(transs);
                        dumLish.add(transs);
                    }

                } else {
                    Log.d("Boholst", "EXCEPTION!");
                }
            }

        });
        return dumLish;

    }

    public static int ListSize() {
        final ArrayList<Transaction> ListTrans = new ArrayList<>();
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Transaction");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> markers, ParseException e) {
                if (e == null) {
                    for (ParseObject obj : markers) {
                        Transaction tranl = new Transaction(obj.getString("objectId"), obj.getString("transactionID"), obj.getString("patientID"), obj.getString("insuranceID"), obj.getString("hospitalID"), obj.getString("DoctorID"), obj.getString("transactionType"), obj.getString("transactionDescription"), obj.getString("transactionDate"), obj.getString("transactionPrice"));

                        ListTrans.add(tranl);
                    }

                } else {
                    // handle Parse Exception here
                }
            }

        });
        return Integer.parseInt(ListTrans.get(ListTrans.size() - 1).getTransactionID());
    }

    public static Transaction getCertainTransactionDetails(String objID) {

        ParseQuery<ParseObject> query2 = ParseQuery.getQuery("Transaction");
        query2.whereEqualTo("objectId", objID);
        query2.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, ParseException e) {
                if (e == null) {
                    for (ParseObject obj : list) {
                        tran = new Transaction(obj.getString("objectId"), obj.getString("transactionID"), obj.getString("patientID"), obj.getString("insuranceID"), obj.getString("hospitalID"), obj.getString("DoctorID"), obj.getString("transactionType"), obj.getString("transactionDescription"), obj.getString("transactionDate"), obj.getString("transactionPrice"));

                    }
                } else {
                    Log.d("role_transaction error", "e");
                }

            }
        });
        if (tran != null) {
            return tran;
        } else {
            Log.d("Error", "Returned null (Get certain)");
            return tran;
        }
    }

    public void addTransaction(String patientID, String insuranceID, String hospitalID, String doctorID, String transtype, String transdesc, String transdate, String transprice) {
        int transactionID = ListSize() + 1;
        ParseObject storyActivity = new ParseObject("Transaction");
        storyActivity.put("transactionID", transactionID);
        storyActivity.put("patientID", patientID);
        storyActivity.put("insuranceID", insuranceID);
        storyActivity.put("hospitalID", hospitalID);
        storyActivity.put("DoctorID", doctorID);
        storyActivity.put("transactionType", transtype);
        storyActivity.put("transactionDescription", transdesc);
        storyActivity.put("transactionDate", transdate);
        storyActivity.put("transactionPrice", transprice);
        storyActivity.saveInBackground(new SaveCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    // your object is successfully created.
                } else {
                    //error occurred
                    Log.d("Error", "Nothing added , Exception " + e);
                }
            }
        });

    }

    public void deleteTransaction(String objID) {
        ParseQuery<ParseObject> query2 = ParseQuery.getQuery("Transaction");
        query2.whereEqualTo("objectId", objID);
        query2.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, ParseException e) {
                if (e == null) {

                    for (ParseObject obj : list) {

                        try {
                            obj.delete();

                        } catch (ParseException e1) {
                            e1.printStackTrace();
                        }


                    }


                } else {

                }
            }
        });
    }
    public void editTransaction(String objID,String patientID,String insuranceID,String hospitalID,String doctorID,String transtype,String transdesc,String transdate,String transprice){
        deleteTransaction(objID);
        addTransaction(patientID, insuranceID, hospitalID, doctorID, transtype, transdesc, transdate, transprice);

    }
}
