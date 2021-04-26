package com.test;

import android.text.TextUtils;
import android.util.Patterns;

public class ValidationUtils {

    public static boolean isEmailValid(String email) {

        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static boolean isPassword(String password) {

        return !TextUtils.isEmpty(password);
    }

}
