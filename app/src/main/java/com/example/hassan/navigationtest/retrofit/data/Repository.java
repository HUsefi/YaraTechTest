package com.example.hassan.navigationtest.retrofit.data;

import com.example.hassan.navigationtest.retrofit.data.model.Post;
import com.example.hassan.navigationtest.retrofit.data.model.User;
import com.example.hassan.navigationtest.retrofit.data.remote.APIClient;
import com.example.hassan.navigationtest.retrofit.data.remote.APIInterface;
import com.example.hassan.navigationtest.retrofit.data.remote.APIResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
    public void getUsersList(final APIResult<List<User>> callBack){
        APIClient apiClient=new APIClient();
        APIInterface service = apiClient.getClient().create(APIInterface.class);
        Call<List<User>> usersList = service.getUsers();
        usersList.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if(response.isSuccessful()){
//                     users =response.body();
                     callBack.onSuccess(response.body());
//                    userRecycleAdapter = new UserRecycleAdapter(getContext(), users,
//                            ListUsersFragment.this);
//                    recyclerView.setAdapter(userRecycleAdapter);
                }

            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
              callBack.onFail();
            }
        });

    }


    public void getPostsList(final APIResult<List<Post>> callBack, int userId){
        APIClient apiClient=new APIClient();
        APIInterface service = apiClient.getClient().create(APIInterface.class);
        Call<List<Post>> usersList = service.getPosts(userId);
        usersList.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if(response.isSuccessful()){
                    callBack.onSuccess(response.body());

                }

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                callBack.onFail();
            }
        });

    }




}

