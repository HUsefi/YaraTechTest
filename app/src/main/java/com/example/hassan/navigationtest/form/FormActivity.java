package com.example.hassan.navigationtest.form;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.hassan.navigationtest.CategoryFragment;
import com.example.hassan.navigationtest.R;

public class FormActivity extends AppCompatActivity implements NameFragment.name,FamilyFragment.family,SubmitFragment.submit{

    public String name,family;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        FragmentManager fragmentManager= getSupportFragmentManager();
        Fragment nameFragment = new NameFragment();
        fragmentManager.beginTransaction()
                .add(R.id.name_container,nameFragment)
                .commit();
        Fragment familyFragment = new FamilyFragment();
        fragmentManager.beginTransaction()
                .add(R.id.family_container,familyFragment)
                .commit();

        Fragment submitFragment = new SubmitFragment();
        fragmentManager.beginTransaction()
                .add(R.id.submit_container,submitFragment)
                .commit();


    }

    @Override
    public void setFamily(String family) {
      this.family = family;
    }

    @Override
    public void setName(String name) {
     this.name=name;
    }

    @Override
    public void buttonPress() {

        Toast.makeText(getApplicationContext(),name+family,Toast.LENGTH_SHORT).show();

    }
}
