package com.example.hassan.navigationtest.retrofit.ui.post;

import com.example.hassan.navigationtest.retrofit.data.Repository;
import com.example.hassan.navigationtest.retrofit.data.model.Post;
import com.example.hassan.navigationtest.retrofit.data.remote.APIResult;

import java.util.List;


public class PostPresenter implements PostConstractor.Presenter {

    PostConstractor.View view;
    private Repository mRepository;

    public PostPresenter(PostConstractor.View view) {
        this.view = view;
        mRepository=new Repository();
    }

    @Override
    public void fetchPostDataFromRemote(int userId) {
        view.showProgress();

        mRepository.getPostsList(new APIResult<List<Post>>() {
            @Override
            public void onSuccess(List<Post> result) {
               // view.hideProgress();
                view.onGetPostDate(result);

            }

            @Override
            public void onFail() {
                view.notAvailablePostDate();
            }
        }, userId);

    }
}
