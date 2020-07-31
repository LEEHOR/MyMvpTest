package com.leehor.mymvptest;


import com.leehor.mvpmodule.base.BasePresenter;
import com.leehor.mvpmodule.base.IBaseView;

public interface MainContract {
    interface view extends IBaseView {
        void Success();
        void Failure();
    }
    abstract class Presenter extends BasePresenter<view> {
        public abstract void startHttp();
    }
}
