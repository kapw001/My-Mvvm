package com.test;

import android.text.TextUtils;
import android.widget.EditText;

import androidx.databinding.BindingAdapter;

public class BindAdapterTest {

    @BindingAdapter({"errorMsg"})
    public static void onError(EditText editText, String errorMsg) {

        if (!TextUtils.isEmpty(errorMsg)) {

            editText.setError(errorMsg);
//        editText.setText(errorMsg);

        } else {

            editText.setError(null);

        }

    }

}
