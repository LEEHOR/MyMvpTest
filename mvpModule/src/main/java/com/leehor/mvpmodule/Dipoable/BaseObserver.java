package com.leehor.mvpmodule.Dipoable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class BaseObserver <T> implements Observer<T> {
    protected  Disposable disposable;

    @Override
    public void onSubscribe(Disposable d) {
        disposable=d;
        //添加订阅关系
        SubscriptionManager.getInstance().add(d);
        OnDisposable();
    }

    @Override
    public void onNext(T t) {
        OnSuccess(t);
    }

    @Override
    public void onError(Throwable e) {
        SubscriptionManager.getInstance().remove(disposable);
        //自定义异常的传递
        OnFail(e);
    }

    @Override
    public void onComplete() {
        SubscriptionManager.getInstance().remove(disposable);
        OnCompleted();
    }
    public abstract void OnDisposable();

    public abstract void OnSuccess(T t);

    public abstract void OnFail(Throwable e);

    public abstract void OnCompleted();


}
