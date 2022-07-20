package com.pinslog.baseprojectjava.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;

public abstract class BaseFragment<VB extends ViewBinding> extends Fragment {

    protected Context mContext;
    protected VB binding;
    protected ViewGroup inflateView;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = getViewBinding(inflater, container);
        inflateView = (ViewGroup) binding.getRoot();

        initListener();
        initSetting();
        initData();
        return binding.getRoot();
    }

    protected abstract VB getViewBinding(LayoutInflater inflater, ViewGroup container);
    protected void initListener(){}
    protected void initSetting(){}
    protected void initData(){}

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mContext = null;
        binding = null;
    }
}
