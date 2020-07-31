package com.leehor.mvpmodule.base;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import io.reactivex.ObservableTransformer;

/**
 * <p>
 * 想要使用mvp，需要继承此BaseMvpActivity
 */

public abstract class BaseMvpActivity<V extends IBaseView, P extends BasePresenter<V>> extends BaseActivity
        implements IBaseView{
    public P presener;
    /**
     * 绑定生命周期
     */
    @Override
    public <T> ObservableTransformer<T, T> bindLifeycle() {
        return this.bindToLifecycle();
    }

    protected abstract P initPresener();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        presener=initPresener();
        presener.attatchView((V) this);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("perfect-mvp", "V onResume");
//        mProxy.onResume((V) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("perfect-mvp", "V onDestroy = ");
        presener.detachView();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e("perfect-mvp", "V onSaveInstanceState");
    }
    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

}
