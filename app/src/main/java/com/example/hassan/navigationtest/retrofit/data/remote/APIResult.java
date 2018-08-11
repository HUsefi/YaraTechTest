package com.example.hassan.navigationtest.retrofit.data.remote;

public interface APIResult<T> {
     void onSuccess(T result);
     void onFail();


}
