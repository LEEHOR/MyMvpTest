package com.leehor.basemvp.base;


import android.os.Bundle;
import android.util.Log;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends IBaseView> {

    /**
     * 解决第一个问题
     * <p>
     * 弱引用, 防止内存泄漏
     */
    private WeakReference<V> mView;


    /**
     * 关联V层和P层
     *
     */
    public void attatchView(V v) {
        mView = new WeakReference<V>(v);


    }


    /**
     * @return P层和V层是否关联.
     */
    public boolean isViewAttached() {
        return mView != null && mView.get() != null;
    }


    /**
     * 断开V层和P层
     * 在Acitivity的onDestory()中调用
     */
    public void detachView() {
        if (isViewAttached()) {
            mView.clear();
            mView = null;
        }
    }

    /**
     * 解决第二个问题
     */


    public V getView() {
        return mView==null?null:mView.get();
    }


    /**
     * 在Presenter意外销毁的时候被调用，它的调用时机和Activity、Fragment、View中的onSaveInstanceState
     * 时机相同
     *
     */
    public void onSaveInstanceState(Bundle presenterBundle) {
        Log.e("perfect-mvp","P onSaveInstanceState = ");
    }

}