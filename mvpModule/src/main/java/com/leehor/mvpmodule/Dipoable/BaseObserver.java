package com.leehor.mvpmodule.Dipoable;
import com.leehor.mvpmodule.base.BasePresenter;
import com.leehor.mvpmodule.base.BaseResponse;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class BaseObserver <T> implements Observer<T> {

    @Override
    public void onSubscribe(Disposable d) {
        //添加订阅关系
        OnDisposable(d);
        //SubscriptionManager.getInstance().add(d);
    }

    @Override
    public void onNext(T t) {
        OnSuccess(t);
    }

    @Override
    public void onError(Throwable e) {
        //自定义异常的传递
        OnFail(e);
    }

    @Override
    public void onComplete() {
        OnCompleted();
    }

    public abstract void OnSuccess(T t);

    public abstract void OnFail(Throwable e);

    public abstract void OnCompleted();

    public abstract void OnDisposable(Disposable d);
}
