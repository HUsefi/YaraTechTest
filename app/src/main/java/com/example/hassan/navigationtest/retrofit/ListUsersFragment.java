package com.example.hassan.navigationtest.retrofit;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.example.hassan.navigationtest.R;
import com.example.hassan.navigationtest.retrofit.model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ListUsersFragment extends Fragment implements UserRecycleAdapter.ItemClickListener{
        private RecyclerView recyclerView;
        private UserRecycleAdapter  userRecycleAdapter;
        private List<User> users = new ArrayList<>();
    public ListUsersFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_list_user, container, false);
        recyclerView=(RecyclerView)view.findViewById(R.id.recycler_view_list_modle);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        userRequest();
        return view;
    }

    private void userRequest() {
        APIClient apiClient=new APIClient();
        APIInterface service = apiClient.getClient().create(APIInterface.class);
        Call<List<User>> usersList = service.getUsers();
        usersList.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if(response.isSuccessful()){
                     users =response.body();
                    userRecycleAdapter = new UserRecycleAdapter(getContext(), users,ListUsersFragment.this);
                    recyclerView.setAdapter(userRecycleAdapter);
                }

            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                if(t instanceof IOException){
                    Toast.makeText(getContext(), "Connection problem!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    @Override
    public void onItemClick(View view, int position) {
        ((ListUsersFragment.OnClick) getContext()).showComments(users.get(position).getId());
    }

    public interface OnClick {
        void showComments(int id);
    }
}
