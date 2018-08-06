package com.example.hassan.navigationtest;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ContactFragment extends Fragment {


    public ContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_contact, container, false);
        TextView textView=(TextView)view.findViewById(R.id.text_view_email);
        TextView textView1=(TextView)view.findViewById(R.id.text_view_link_git);
        return view;
    }

}
