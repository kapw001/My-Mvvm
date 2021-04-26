package com.test;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel implements Observer<String> {


    public MutableLiveData<String> mEmail = new MutableLiveData<>();
    public MutableLiveData<String> mErrorEmail = new MutableLiveData<>();
    public MutableLiveData<String> mPassword = new MutableLiveData<>();
    public MutableLiveData<String> mErrorPassword = new MutableLiveData<>();

    private MediatorLiveData<Boolean> valid = new MediatorLiveData<>();


    private MutableLiveData<Login> loginStatus = new MutableLiveData<>();

    public MainViewModel() {

        valid.setValue(false);
        valid.addSource(mEmail, new Observer<String>() {
            @Override
            public void onChanged(String s) {

                valid.setValue(ValidationUtils.isEmailValid(s));

            }
        });

        valid.addSource(mPassword, new Observer<String>() {
            @Override
            public void onChanged(String s) {

                valid.setValue(ValidationUtils.isPassword(s));

            }
        });


//        mEmail.observeForever(this);
//        mPassword.observeForever(this);

    }


    public void onLoginClicked() {

//        mErrorEmail.setValue("Email error");
//        mErrorPassword.setValue("Password Error");


        if (!ValidationUtils.isEmailValid(mEmail.getValue())) {
            mErrorEmail.setValue("Email error");
        }

        if (!ValidationUtils.isPassword(mPassword.getValue())) {
            mErrorPassword.setValue("Password Error");
        }


        if (ValidationUtils.isEmailValid(mEmail.getValue()) && ValidationUtils.isPassword(mPassword.getValue())) {

            loginStatus.setValue(new Login(mEmail.getValue(), mPassword.getValue()));

        }


    }

    public LiveData<Login> getLoginStatus() {
        return loginStatus;
    }

    @Override
    public void onChanged(String s) {

        if (!ValidationUtils.isEmailValid(mEmail.getValue())) {
            mErrorEmail.setValue("Email error");
        }

        if (!ValidationUtils.isPassword(mPassword.getValue())) {
            mErrorPassword.setValue("Password Error");
        }

    }

    public LiveData<Boolean> getValid() {
        return valid;
    }
}
