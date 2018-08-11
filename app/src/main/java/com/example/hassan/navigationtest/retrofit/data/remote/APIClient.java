package com.example.hassan.navigationtest.retrofit.data.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    public static final String BASE_URL="https://jsonplaceholder.typicode.com/";
    private static Retrofit retrofit=null;
    public Retrofit getClient(){
         if(retrofit== null){
             retrofit = new Retrofit.Builder()
                     .baseUrl(BASE_URL)
                     .addConverterFactory(GsonConverterFactory.create())
                     .build();
         }
         return retrofit;
    }
}
