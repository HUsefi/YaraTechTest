package com.example.hassan.navigationtest;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.parceler.Parcels;

public class InfoActivity extends AppCompatActivity {

    private TextView mTextViewInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Intent intent=getIntent();
        Person person = Parcels.unwrap(intent.getParcelableExtra("UserExtera"));
         TextView textView=(TextView) findViewById(R.id.edit_text_info);

         textView.setText(person.getmName()+"\n");
         textView.append(person.getmFamily()+"\n");
         textView.append(person.getmEmail());




    }
}
