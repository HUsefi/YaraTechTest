package com.example.hassan.navigationtest.retrofit;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import com.example.hassan.navigationtest.R;
import com.example.hassan.navigationtest.retrofit.ui.post.ListPostUserFragment;
import com.example.hassan.navigationtest.retrofit.ui.user.ListUsersFragment;

public class RetrofitActivity extends AppCompatActivity implements ListUsersFragment.OnClick {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        Fragment listModelFragment = new ListUsersFragment();
        setFragment(listModelFragment);



    }

   void  setFragment(Fragment fragment){
       FragmentManager fragmentManager=getSupportFragmentManager();
       fragmentManager.beginTransaction()
               .replace(R.id.fragment_container,fragment)
               .addToBackStack(null)
               .commit();
    }

    @Override
    public void showComments(int id) {

        setFragment(ListPostUserFragment.newInstance(id));
    }
}
