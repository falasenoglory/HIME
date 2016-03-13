//package com.jimbofer.hime.fragments;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AdapterView;
//import android.widget.ListView;
//import android.widget.TextView;
//
//import com.jimbofer.hime.ParseUtils.Parse_Patient;
//import com.jimbofer.hime.R;
//
///**
// * Created by Shanyl Jimenez on 3/13/2016.
// */
//public class ListViewFragmentPatient extends Fragment implements AdapterView.OnItemClickListener{
//
//    private ListView mListView;
//    private TextView mTvEmpty;
//
//    private Parse_Patient mController;
//
//    public static ListViewFragment newInstance() {
//        return new ListViewFragment();
//    }
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        mController = new Parse_Patient();
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_listviewpatients, container, false);
//    }
//
//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        // find all the views
//        mListView = (ListView) view.findViewById(R.id.listView);
//        mTvEmpty = (TextView) view.findViewById(android.R.id.empty);
//
//        // create a new instance of adapter
//        MoviesAdapter adapter = new MoviesAdapter(getActivity(),
//                R.layout.list_item, mController.getMovies());
//
//        // set the adapter
//        mListView.setAdapter(adapter);
//
//        // set item click listener
//        mListView.setOnItemClickListener(this);
//    }
//
//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Intent intent = new Intent(getActivity(), MovieDetailsActivity.class);
//        intent.putExtra(Constants.EXTRA_POSITION, position);
//        startActivity(intent);
//
//}
