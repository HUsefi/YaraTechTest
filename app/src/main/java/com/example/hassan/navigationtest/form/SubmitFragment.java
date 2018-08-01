package com.example.hassan.navigationtest.form;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.hassan.navigationtest.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SubmitFragment extends Fragment {

    private  Button mButtonSubmit;
    public SubmitFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_submit, container, false);

        Button button = (Button)view.findViewById(R.id.button_submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((SubmitFragment.submit)getContext()).buttonPress();
            }
        });

        return view;
    }
    public interface submit{
        void buttonPress();
    }

}
