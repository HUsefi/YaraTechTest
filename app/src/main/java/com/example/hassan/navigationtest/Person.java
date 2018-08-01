package com.example.hassan.navigationtest;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

@Parcel
public class Person {

    private String mName;
    private String mFamily;
    private String mEmail;

    @ParcelConstructor
    public Person(String mName, String mFamily, String mEmail) {
        this.mName = mName;
        this.mFamily = mFamily;
        this.mEmail = mEmail;
    }

    public String getmName() {
        return mName;
    }


    public String getmFamily() {
        return mFamily;
    }


    public String getmEmail() {
        return mEmail;
    }



}
