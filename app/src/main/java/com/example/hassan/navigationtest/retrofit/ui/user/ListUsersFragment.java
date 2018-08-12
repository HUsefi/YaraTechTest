package com.example.hassan.navigationtest.retrofit.ui.user;


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
import com.example.hassan.navigationtest.retrofit.data.model.User;
import com.example.hassan.navigationtest.retrofit.ui.post.PostConstractor;

import java.util.ArrayList;
import java.util.List;


public class ListUsersFragment extends Fragment implements UserConstractor.view

        , UserRecycleAdapter.ItemClickListener {

    private ProgressBar progressBar;
    private UserConstractor.presenter mUserPresenter;

    private RecyclerView recyclerView;
    private UserRecycleAdapter userRecycleAdapter;
    private List<User> users = new ArrayList<>();

    public ListUsersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_user, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_list_modle);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        userRecycleAdapter = new UserRecycleAdapter(getContext(), ListUsersFragment.this);
        recyclerView.setAdapter(userRecycleAdapter);
        mUserPresenter = new UserPresenter(this);
        mUserPresenter.fetchDataFromRemote();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void notAvailableDate() {
        Toast.makeText(getContext(), "not available data", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onGetDate(List<User> usersList) {
        users=usersList;
        userRecycleAdapter.setDate(usersList);
    }


    @Override
    public void onItemClick(View view, int position) {
        ((ListUsersFragment.OnClick) getContext()).showComments(users.get(position).getId());
    }

    public interface OnClick {
        void showComments(int id);
    }


}
