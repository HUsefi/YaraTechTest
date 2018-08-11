package com.example.hassan.navigationtest.retrofit.ui.user;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.hassan.navigationtest.R;
import com.example.hassan.navigationtest.retrofit.data.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRecycleAdapter extends RecyclerView.Adapter<UserRecycleAdapter.UserHolder> {

    private LayoutInflater layoutInflater;
    ItemClickListener itemClickListener;
    private Context context;
    private List<User> users = new ArrayList<>();


    // data is passed into the constructor
    public UserRecycleAdapter(Context context, ItemClickListener itemClickListener) {
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.users = users;
        this.itemClickListener = itemClickListener;
    }


    // inflates the row layout from xml when needed
    @NonNull
    @Override
    public UserRecycleAdapter.UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.item_row, parent, false);
        return new UserRecycleAdapter.UserHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(@NonNull UserRecycleAdapter.UserHolder holder, int position) {

        holder.nameTextView.setText(users.get(position).getName());
        holder.phoneTextView.setText(users.get(position).getPhone());
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return users.size();
    }


    public void setDate(List<User> users) {
        this.users = users;
        notifyDataSetChanged();
    }


    // stores and recycles views as they are scrolled off screen
    public class UserHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView nameTextView, phoneTextView;


        public UserHolder(View itemView) {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.text_view_name);
            phoneTextView = (TextView) itemView.findViewById(R.id.text_view_phone);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (itemClickListener != null)
                itemClickListener.onItemClick(view, getAdapterPosition());
        }
    }


    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

}


