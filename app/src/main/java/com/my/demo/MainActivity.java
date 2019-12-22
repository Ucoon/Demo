package com.my.demo;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.my.autosize.DensityUtils;
import com.my.demo.fragment.LazyFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DensityUtils.setCustomDensity(this, getApplication());
        setContentView(R.layout.activity_lazy_layout);
        LazyFragment fragment = new LazyFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_layout, fragment, LazyFragment.class.getSimpleName());
        transaction.commitNowAllowingStateLoss();
    }
}
