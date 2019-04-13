package com.my.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.my.autosize.DensityUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DensityUtils.setCustomDensity(this, getApplication());
        setContentView(R.layout.activity_main);
    }
}
