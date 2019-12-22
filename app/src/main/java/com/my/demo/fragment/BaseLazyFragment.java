package com.my.demo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseLazyFragment extends Fragment {
    private static final String TAG = BaseLazyFragment.class.getSimpleName();

    //第一次可见状态，第一次不可见状态
    private boolean isFirstVisible = true;
    private boolean isFirstInVisible = true;
    private boolean isPrepared;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e(TAG, "onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG, "onCreateView");
        if (getContentViewLayoutID() != 0) {
            return inflater.inflate(getContentViewLayoutID(), null);
        } else {
            return super.onCreateView(inflater, container, savedInstanceState);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e(TAG, "onViewCreated");
        initView(view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(TAG, "onActivityCreated");
        initPrepared();
    }

    private synchronized void initPrepared() {
        if (isPrepared) {
            onFirstUserVisible();
        } else {
            isPrepared = true;
        }
    }

    //可见状态，不可见状态
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.e(TAG, "setUserVisibleHint");
        if (isVisibleToUser) {
            if (isFirstVisible) {
                isFirstVisible = false;
                initPrepared();
            } else {
                onUserVisible();
            }
        } else {
            if (isFirstInVisible) {
                isFirstInVisible = false;
                onFirstUserInVisible();
            } else {
                onUserInVisible();
            }
        }
    }

    @Override
    public void onDestroy() {
        destroyViewAndThing();
        super.onDestroy();
    }

    protected abstract int getContentViewLayoutID();

    protected abstract void initView(View view);

    //建议在此函数内初始化view或请求数据（only once的那种）
    protected abstract void onFirstUserVisible();

    protected abstract void onFirstUserInVisible();

    //相当于onResume()
    protected abstract void onUserVisible();

    protected abstract void onUserInVisible();

    protected abstract void destroyViewAndThing();

}
