package com.jimbofer.hime.fragments;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.jimbofer.hime.R;

public class DialogBox extends DialogFragment implements View.OnClickListener {

    public interface OnItemClickListener {
        void onOkItemClickListener();

        void onCancelItemClickListener();
    }

    Spinner months;
    Spinner days;
    Button okAction;
    Button cancelAction;
    ArrayAdapter<CharSequence> monthsAdapter;
    ArrayAdapter<CharSequence> daysAdapter;
    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_set_appointment, container, false);
        months = (Spinner) view.findViewById(R.id.months_spinner);
        days = (Spinner) view.findViewById(R.id.days_spinner);
        okAction = (Button) view.findViewById(R.id.ok_action);
        cancelAction = (Button) view.findViewById(R.id.cancel_action);
        okAction.setOnClickListener(this);
        cancelAction.setOnClickListener(this);

        monthsAdapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.months_array,
                android.R.layout.simple_spinner_item);

        daysAdapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.days_array,
                android.R.layout.simple_spinner_item);

        monthsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        months.setAdapter(monthsAdapter);

        daysAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        days.setAdapter(daysAdapter);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ok_action: {
                mOnItemClickListener.onOkItemClickListener();
                break;
            }
            case R.id.cancel_action: {
                mOnItemClickListener.onCancelItemClickListener();
                break;
            }
        }
    }

    public String getDate() {
        return " " + months.getSelectedItem() + "-" + days.getSelectedItem() + "-" + "16";
    }

}
