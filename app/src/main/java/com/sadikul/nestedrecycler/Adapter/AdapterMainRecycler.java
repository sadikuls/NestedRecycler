package com.sadikul.nestedrecycler.Adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sadikul.nestedrecycler.Model.InnerRecyclerItem;
import com.sadikul.nestedrecycler.Model.RecyclerViewItem;
import com.sadikul.nestedrecycler.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 01-Jan-18.
 */

public class AdapterMainRecycler extends RecyclerView.Adapter<AdapterMainRecycler.viewHolder>{

    List<RecyclerViewItem> recyclerViewItems;
    Context context;

    public AdapterMainRecycler(Context context) {
        this.recyclerViewItems = new ArrayList<>();
        this.context = context;
    }

    //set items value
    public void setRecyclerViewItems(List<RecyclerViewItem> recyclerViewItems){
        this.recyclerViewItems = recyclerViewItems;
        notifyDataSetChanged();
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_recyclerview,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {
        RecyclerViewItem item = recyclerViewItems.get(position);
        List<InnerRecyclerItem> innerRecyclerItem = item.getInnerRecyclerItem();
        holder.nameTextview.setText(item.getName());

        for(int i = 0 ; i<innerRecyclerItem.size();i++){
            Log.e("innerInAdapter",item.getName()+" "+ innerRecyclerItem.size()+" "+ i);
        }


        holder.innerAdapter.setData(item.getInnerRecyclerItem()); // List of Strings
        holder.innerAdapter.setRowIndex(position);


    }

    @Override
    public int getItemCount() {
        return recyclerViewItems.size();
    }

    class viewHolder extends RecyclerView.ViewHolder{

        TextView nameTextview;
        RecyclerView innerRecyclerView;
        InnerRecyclerviewAdapter innerAdapter;
        public viewHolder(View itemView) {
            super(itemView);
            nameTextview = itemView.findViewById(R.id.item_name_textview);
            innerRecyclerView = itemView.findViewById(R.id.innerRecyclerView);
            innerRecyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));

            innerAdapter = new InnerRecyclerviewAdapter();
            innerRecyclerView.setAdapter(innerAdapter);
        }
    }
}
