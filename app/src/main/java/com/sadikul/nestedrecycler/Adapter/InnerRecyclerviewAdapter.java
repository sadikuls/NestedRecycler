package com.sadikul.nestedrecycler.Adapter;

import android.content.Context;
import android.graphics.Color;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sadikul.nestedrecycler.Model.InnerRecyclerItem;
import com.sadikul.nestedrecycler.R;

import java.util.List;

/**
 * Created by Sadikul on 12/30/2017.
 */

public class InnerRecyclerviewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String TAG = "Inner";
    private List<InnerRecyclerItem> InnerRecyclerItems;
    private int mRowIndex = -1;
    private int mSelectedPosition = -1;

    public InnerRecyclerviewAdapter() {
        Log.d(TAG, "constructor");
    }

    public void setData(List<InnerRecyclerItem> InnerRecyclerItems) {

        Log.d(TAG, "setData");
        if (InnerRecyclerItems != null) {
            this.InnerRecyclerItems = InnerRecyclerItems;
            notifyDataSetChanged();
        }
    }

    public void setRowIndex(int index) {

        Log.d(TAG, "setRowIndex");
        mRowIndex = index;
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView text;
        private View mView;

        public ItemViewHolder(View itemView) {

            super(itemView);
            mView = itemView;
            text = (TextView) itemView.findViewById(R.id.item_inner_textview);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_inner_recyclerview, parent, false);
        ItemViewHolder holder = new ItemViewHolder(itemView);
        Log.d(TAG, "onCreateViewHolder");
        return holder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder rawHolder, final int position) {
        Log.d(TAG, "onBindViewHolder");
        ItemViewHolder holder = (ItemViewHolder) rawHolder;
        InnerRecyclerItem item = InnerRecyclerItems.get(position);
        holder.text.setText(item.getName());
        holder.itemView.setTag(position);
        if(mSelectedPosition == position){
            holder.mView.setBackgroundColor(Color.YELLOW);
        }else{
            holder.mView.setBackgroundColor(Color.GRAY);
        }
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("InnerRecycler", "Recycler position = :" + rawHolder.getAdapterPosition() +" pos: "+position);
                mSelectedPosition = rawHolder.getAdapterPosition();
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount");
        return InnerRecyclerItems.size();
    }

}