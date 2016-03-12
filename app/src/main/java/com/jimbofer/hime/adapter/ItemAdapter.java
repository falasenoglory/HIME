package com.jimbofer.hime.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jimbofer.hime.R;
import com.jimbofer.hime.models.items;

import java.util.List;

/**
 * Created by Shanyl Jimenez on 3/12/2016.
 */
public class ItemAdapter extends ArrayAdapter<items> {


        private Context mContext;
        private int mLayoutId;
        private List<items> mItems;

        public ItemAdapter(Context context, int resource, List<items> Item) {
            super(context, resource, Item);

            mContext = context;
            mLayoutId = resource;
            mItems = Item;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;

            if (convertView == null) {
                // Inflate the layout
                convertView = LayoutInflater.from(mContext).inflate(mLayoutId, parent, false);

                // create the view holder
                viewHolder = new ViewHolder();
                viewHolder.imgText = (ImageView) convertView.findViewById(R.id.imgItem);
                viewHolder.tvName = (TextView) convertView.findViewById(R.id.txtText);

                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            // Set the movie data
            items insurance = mItems.get(position);

            if (insurance != null) {
                Log.d("just", " this "+insurance.getItem().toString());
                if (viewHolder.tvName != null) {
                    Log.d("just", insurance.getItem().toString());
                    viewHolder.tvName.setText(insurance.getItem().toString());
                }

            }

            return convertView;
        }

        private static class ViewHolder {
            public TextView tvName;
            public ImageView imgText;

        }


}
