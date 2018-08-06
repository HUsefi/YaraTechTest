package com.example.hassan.navigationtest.retrofit;

import com.example.hassan.navigationtest.retrofit.model.Post;
import com.example.hassan.navigationtest.retrofit.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {

    @GET ("users")
    Call<List<User>> getUsers();

    @GET("posts")
    Call<List<Post>> getPosts(@Query("userId") int id) ;
}
