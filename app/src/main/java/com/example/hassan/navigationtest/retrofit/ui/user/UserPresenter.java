package com.example.hassan.navigationtest.retrofit.ui.user;

import com.example.hassan.navigationtest.retrofit.data.Repository;
import com.example.hassan.navigationtest.retrofit.data.model.User;
import com.example.hassan.navigationtest.retrofit.data.remote.APIResult;

import java.util.List;

public class UserPresenter implements UserConstractor.presenter{

    UserConstractor.view view;
    private Repository mRepository;

    public UserPresenter(UserConstractor.view view) {
        this.view = view;
        mRepository = new Repository();
    }

    @Override
    public void fetchDataFromRemote() {
        view.showProgress();

        mRepository.getUsersList(new APIResult<List<User>>() {
            @Override
            public void onSuccess(List<User> result) {
                view.onGetDate(result);
            }

            @Override
            public void onFail() {
                view.notAvailableDate();
            }
        });

    }
}
