package com.leehor.mvpmodule.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.IdRes;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;

import com.trello.rxlifecycle2.components.support.RxFragment;

/**
 * yangyoupeng on 2018/4/3.
 */
@Keep
public abstract class BaseFragment extends RxFragment {

    protected BaseActivity mActivity;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = (BaseActivity) context;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getFragmentLayout(), container, false);
       // ButterKnife.bind(this, inflate);

        initData();
        initView();
       // EventBus.getDefault().register(this);
        return inflate;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
       // EventBus.getDefault().unregister(this);
    }

    /**
     * 当Activity初始化之后可以在这里进行一些数据的初始化操作
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    public abstract int getFragmentLayout();

    protected abstract void initView();

    protected abstract void initData();

    /**
     * 获取宿主Activity
     *
     * @return BaseActivity
     */
    protected BaseActivity getHoldingActivity() {
        return mActivity;
    }


    /**
     * 添加fragment
     */
    protected void addFragment(BaseFragment fragment, @IdRes int frameId) {
      //  Utils.checkNotNull(fragment);
        getHoldingActivity().addFragment(fragment, frameId);

    }


    /**
     * 替换fragment
     */
    protected void replaceFragment(BaseFragment fragment, @IdRes int frameId) {
       // Utils.checkNotNull(fragment);
        getHoldingActivity().replaceFragment(fragment, frameId);
    }


    /**
     * 隐藏fragment
     */
    protected void hideFragment(BaseFragment fragment) {
        //Utils.checkNotNull(fragment);
        getHoldingActivity().hideFragment(fragment);
    }


    /**
     * 显示fragment
     */
    protected void showFragment(BaseFragment fragment) {
       // Utils.checkNotNull(fragment);
        getHoldingActivity().showFragment(fragment);
    }


    /**
     * 移除Fragment
     */
    protected void removeFragment(BaseFragment fragment) {
       // Utils.checkNotNull(fragment);
        getHoldingActivity().removeFragment(fragment);

    }


    /**
     * 弹出栈顶部的Fragment
     */
    protected void popFragment() {
        getHoldingActivity().popFragment();
    }

//    @Subscribe
//    public void onEventType(EventType eventType) {
//
//    }

    public void showLoadingDialog(){

    }

    public void hideLoadingDialog(){

    }

}
