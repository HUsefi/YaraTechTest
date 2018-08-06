package com.example.hassan.navigationtest.retrofit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.hassan.navigationtest.R;
import com.example.hassan.navigationtest.retrofit.model.User;

import java.util.List;

public class UserRecycleAdapter extends  RecyclerView.Adapter <UserRecycleAdapter.UserHolder> {

        private LayoutInflater layoutInflater;
        ItemClickListener itemClickListener;
        private Context context;
        private List<User> users;

        public UserRecycleAdapter(Context context, List<User> users,ItemClickListener itemClickListener) {
            layoutInflater = LayoutInflater.from(context);
            this.context = context;
            this.users = users;
            this.itemClickListener=itemClickListener;
        }

        @NonNull
        @Override
        public UserRecycleAdapter.UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View view = layoutInflater.inflate(R.layout.item_row,parent,false);
            return new UserRecycleAdapter.UserHolder(view);
        }


    @Override
        public void onBindViewHolder(@NonNull UserRecycleAdapter.UserHolder holder, int position) {

            holder.nameTextView.setText(users.get(position).getName());
            holder.phoneTextView.setText(users.get(position).getPhone());
        }

    public class UserHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView nameTextView,phoneTextView;
        public UserHolder(View itemView) {
            super(itemView);
            nameTextView=(TextView) itemView.findViewById(R.id.text_view_name);
            phoneTextView=(TextView) itemView.findViewById(R.id.text_view_phone);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (itemClickListener != null) itemClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }


    @Override
        public int getItemCount() {
            return users.size();
        }

    }


