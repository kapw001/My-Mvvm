package com.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.test.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        MainViewModel mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        mainBinding.setMv(mainViewModel);
        mainBinding.setLifecycleOwner(this);

        mainViewModel.getLoginStatus().observe(this, new Observer<Login>() {
            @Override
            public void onChanged(Login s) {

                Toast.makeText(MainActivity.this, "" + s, Toast.LENGTH_SHORT).show();

            }
        });

        mainViewModel.getValid().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {

                mainBinding.login.setEnabled(aBoolean);

            }
        });

    }
}
