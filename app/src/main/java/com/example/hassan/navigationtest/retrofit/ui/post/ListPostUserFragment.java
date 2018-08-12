package com.example.hassan.navigationtest.retrofit.ui.post;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.hassan.navigationtest.R;
import com.example.hassan.navigationtest.retrofit.data.model.Post;
import com.example.hassan.navigationtest.retrofit.data.model.User;
import com.example.hassan.navigationtest.retrofit.data.remote.APIClient;
import com.example.hassan.navigationtest.retrofit.data.remote.APIInterface;
import com.example.hassan.navigationtest.retrofit.ui.user.ListUsersFragment;
import com.example.hassan.navigationtest.retrofit.ui.user.UserConstractor;
import com.example.hassan.navigationtest.retrofit.ui.user.UserPresenter;
import com.example.hassan.navigationtest.retrofit.ui.user.UserRecycleAdapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ListPostUserFragment extends Fragment implements PostConstractor.View{

    private ProgressBar mprogressBar;
    private PostConstractor.Presenter mPostPresenter;
    private RecyclerView recyclerView;
    private PostRecycleAdapter postRecycleAdapter;
    private List<Post> posts = new ArrayList<>();


    public ListPostUserFragment() {
    }

    public static ListPostUserFragment newInstance(int id) {

        Bundle args = new Bundle();
        args.putInt("UserId", id);
        ListPostUserFragment fragment = new ListPostUserFragment();
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_post_user, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) view.findViewById(R.id.list_post_user);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        mprogressBar = (ProgressBar) view.findViewById(R.id.progress_bar_post);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        postRecycleAdapter = new PostRecycleAdapter(getContext(),posts);
        recyclerView.setAdapter(postRecycleAdapter);
        mPostPresenter = new PostPresenter(this);
        mPostPresenter.fetchPostDataFromRemote(getArguments().getInt("UserId"));

    }

    @Override
    public void showProgress() {
        mprogressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mprogressBar.setVisibility(View.GONE);
    }

    @Override
    public void notAvailablePostDate() {
        Toast.makeText(getContext(),"not available data",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onGetPostDate(List<Post> postsList) {
        postRecycleAdapter.setDate(postsList);
    }
}
