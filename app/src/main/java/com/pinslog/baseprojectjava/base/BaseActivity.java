package com.pinslog.baseprojectjava.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

import io.reactivex.disposables.Disposable;

public abstract class BaseActivity<VB extends ViewBinding> extends AppCompatActivity {

    public Context mContext;
    public VB binding;
    protected ViewGroup inflateView;
    protected Disposable disposable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = getViewBinding(getLayoutInflater());
        inflateView = (ViewGroup) binding.getRoot();

        setContentView(binding.getRoot());
        mContext = BaseActivity.this;

        initListener();
        initSetting();
        initData();

    }

    protected abstract VB getViewBinding(LayoutInflater inflater);

    protected void initListener() {
    }

    protected void initData() {
    }

    protected void initSetting() {
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mContext = null;
        binding = null;
    }

    /**
     * editText 가 아닌 곳을 클릭 시 키보드 숨기기
     *
     * @param ev MotionEvent
     * @return ev
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View view = getCurrentFocus(); // 현재 터치 위치
        if (view != null
                && (ev.getAction() == MotionEvent.ACTION_UP || ev.getAction() == MotionEvent.ACTION_MOVE)
                && view instanceof EditText
                && !view.getClass().getName().startsWith("android.webkit.")) {
            // view 의 id 가 명시되어있지 않은 다른 부분을 터치 시
            int[] scored = new int[2];
            view.getLocationOnScreen(scored);
            float x = ev.getRawX() + view.getLeft() - scored[0]; // 0은 마지막 터치 위치에서 x값
            float y = ev.getRawY() + view.getTop() - scored[1]; // 1은 마지막 터치 위치에서 y값
            if (x < view.getLeft() || x > view.getRight() || y < view.getTop() || y > view.getBottom())
                ((InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow((this.getWindow().getDecorView().getApplicationWindowToken()), 0);
        }
        return super.dispatchTouchEvent(ev);
    }
}
