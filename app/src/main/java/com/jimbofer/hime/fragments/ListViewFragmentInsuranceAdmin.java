package com.jimbofer.hime.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jimbofer.hime.R;
import com.jimbofer.hime.adapters.ItemAdapter;
import com.jimbofer.hime.controllers.InsuranceAdminControllers;


/**
 * A placeholder fragment containing a {@link ListView}.
 */
public class ListViewFragmentInsuranceAdmin extends Fragment implements AdapterView.OnItemClickListener {

    private ListView mListView;
    private InsuranceAdminControllers mController;

    public static ListViewFragmentInsuranceAdmin newInstance() {
        return new ListViewFragmentInsuranceAdmin();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mController = new InsuranceAdminControllers();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listview_insurance_admin, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        // find all the views
        mListView = (ListView) view.findViewById(R.id.listView);
//        mTvEmpty = (TextView) view.findViewById(android.R.id.empty);

        Log.d("shan",mController.getItem().toString());

        // create a new instance of adapter
        ItemAdapter adapter = new ItemAdapter(getActivity(),
                R.layout.item_list, mController.getItem());

        // set the adapter
        mListView.setAdapter(adapter);

//        if (adapter.isEmpty()) {
//            mTvEmpty.setVisibility(View.VISIBLE);
//        } else {
//            mTvEmpty.setVisibility(View.GONE);
//        }

        // set item click listener
        mListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Intent intent = new Intent(getActivity(), MovieDetailsActivity.class);
//        intent.putExtra(Constants.EXTRA_POSITION, position);
//        startActivity(intent);
    }
}
