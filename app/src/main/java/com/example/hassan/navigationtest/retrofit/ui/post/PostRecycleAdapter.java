package com.example.hassan.navigationtest.retrofit.ui.post;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hassan.navigationtest.R;
import com.example.hassan.navigationtest.retrofit.data.model.Post;


import java.util.List;

public class PostRecycleAdapter extends RecyclerView.Adapter<PostRecycleAdapter.UserHolder> {

    private LayoutInflater layoutInflater;
    private Context context;
    private List<Post> posts;

    public PostRecycleAdapter(Context context, List<Post> posts) {
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.posts = posts;
    }

    @NonNull
    @Override
    public PostRecycleAdapter.UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.post_item_row, parent, false);
        return new PostRecycleAdapter.UserHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull PostRecycleAdapter.UserHolder holder, int position) {

        holder.postTextView.setText(posts.get(position).getBody());

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }


    public void setDate(List<Post> posts) {
        this.posts = posts;
        notifyDataSetChanged();
    }


    public class UserHolder extends RecyclerView.ViewHolder {
        private TextView postTextView;

        public UserHolder(View itemView) {
            super(itemView);
            postTextView = (TextView) itemView.findViewById(R.id.text_view_post);
        }
    }

}

