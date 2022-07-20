package com.pinslog.baseprojectjava;

import android.view.LayoutInflater;

import com.pinslog.baseprojectjava.base.BaseActivity;
import com.pinslog.baseprojectjava.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding> {


    @Override
    protected ActivityMainBinding getViewBinding(LayoutInflater inflater) {
        binding = ActivityMainBinding.inflate(inflater);
        return binding;
    }
}