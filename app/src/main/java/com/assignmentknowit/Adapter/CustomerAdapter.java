package com.assignmentknowit.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.assignmentknowit.Model.OrderItems;
import com.assignmentknowit.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder> implements Filterable {


    Context mCtx;
    List<OrderItems> orderItems;
    List<OrderItems>mFilteredList;

    public CustomerAdapter(Context mCtx, List<OrderItems> orderItemsList) {
        this.mCtx = mCtx;
        this.orderItems = orderItemsList;
        this.mFilteredList =orderItemsList;
    }

    @NonNull
    @Override
    public CustomerViewHolder onCreateViewHolder( ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_layout,viewGroup,false);
        return new CustomerViewHolder(view);

    }


    @Override
    public void onBindViewHolder(@NonNull CustomerViewHolder viewHolder, int position) {

        viewHolder.textView.setText(mFilteredList.get(position).getName());
        Glide.with(mCtx)
                .load(mFilteredList.get(position).getImageurl())
                .into(viewHolder.imageView);



    }

    @Override
    public int getItemCount() {

        return mFilteredList == null ? 0 : mFilteredList.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();

                if (charString.isEmpty()) {
                    mFilteredList = orderItems;
                } else {

                    ArrayList<OrderItems> filteredList = new ArrayList<>();

                    for (OrderItems orderItems : orderItems) {

                        if (orderItems.getName().toLowerCase().contains(charString) || orderItems.getName().toLowerCase().contains(charString) ) {

                            filteredList.add(orderItems);
                        }
                    }

                    mFilteredList = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = mFilteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mFilteredList = (ArrayList<OrderItems>) filterResults.values;
                notifyDataSetChanged();
            }
            };
        }


    class CustomerViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;


        public CustomerViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.txt_date);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
