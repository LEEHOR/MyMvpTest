package com.leehor.mymvptest;

import android.os.Bundle;
import android.widget.Toast;

import com.leehor.mvpmodule.base.BaseMvpActivity;


public class MainActivity extends BaseMvpActivity<MainContract.view, MainPresenter> implements MainContract.view {

    @Override
    protected MainPresenter initPresener() {
        return new MainPresenter();
    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        presener.startHttp();
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    public void Success() {
        Toast.makeText(this,"发起网络请求",Toast.LENGTH_LONG).show();
    }

    @Override
    public void Failure() {
        Toast.makeText(this,"发起网络请求错误",Toast.LENGTH_LONG).show();
    }
}