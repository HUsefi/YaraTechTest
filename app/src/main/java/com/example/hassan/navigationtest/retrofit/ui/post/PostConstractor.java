package com.example.hassan.navigationtest.retrofit.ui.post;

import com.example.hassan.navigationtest.retrofit.data.model.Post;

import java.util.List;

public interface PostConstractor {

    public interface View {
        void showProgress();

        void hideProgress();

        void notAvailablePostDate();

        void onGetPostDate(List<Post> postsList);
    }

    public interface Presenter {
        void fetchPostDataFromRemote(int userId);

    }
}
