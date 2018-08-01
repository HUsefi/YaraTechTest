package com.example.hassan.navigationtest;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import org.parceler.Parcels;

public class RegisterFragment extends Fragment {

    private EditText mName, mFamily,mEmail;
    private Button mSign, mCancle;
    private ImageView mImageYara;
    public RegisterFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View  view= inflater.inflate(R.layout.fragment_register, container, false);
      ImageView imageViewYara=(ImageView)view.findViewById(R.id.image_yara);
      final EditText editTextName = (EditText)view.findViewById(R.id.edit_text_name);
      final EditText editTextFamily = (EditText)view.findViewById(R.id.edit_Text_Family);
      final EditText editTextEmail = (EditText)view.findViewById(R.id.edit_Text_Email);
      Button buttonSign = (Button)view.findViewById(R.id.button_sign);
      Button buttonCancle = (Button)view.findViewById(R.id.button_cancle);

      buttonSign.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
           Person person = new Person(editTextName.getText().toString(),
                   editTextFamily.getText().toString(),
                   editTextEmail.getText().toString());
              Intent intent = new Intent(getContext(),InfoActivity.class);
              intent.putExtra("UserExtera", Parcels.wrap(person));
              startActivity(intent);
          }
      });

        Glide.with(this)
                .load("http://yaramobile.com/templates/sj_hexagon/images/styling/blue/logo.png").into(imageViewYara);

      return view;

    }

}
