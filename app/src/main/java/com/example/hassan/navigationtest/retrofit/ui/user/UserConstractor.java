package com.example.hassan.navigationtest.retrofit.ui.user;

import com.example.hassan.navigationtest.retrofit.data.model.User;

import java.util.List;

public interface UserConstractor {

    public interface view{
        void showProgress();
        void hideProgress();
        void notAvailableDate();
        void onGetDate(List<User> usersList);
    }

    public interface presenter{
        void fetchDataFromRemote();

    }

}
