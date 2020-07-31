package com.leehor.basemvp.base;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import io.reactivex.ObservableTransformer;



public abstract class BaseMvpFragment<V extends IBaseView, P extends BasePresenter<V>> extends BaseFragment
        implements  IBaseView {
    private static final String PRESENTER_SAVE_KEY = "presenter_save_key";
    public P presener;
    protected abstract P initPresener();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initPresener();
        presener.attatchView((V)this);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("perfect-mvp", "V onResume");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("perfect-mvp", "V onDestroy = ");
        presener.detachView();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e("perfect-mvp", "V onSaveInstanceState");
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {
    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifeycle() {
        return this.bindToLifecycle();
    }
}
