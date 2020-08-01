package com.leehor.mvpmodule.Dipoable;

import io.reactivex.disposables.Disposable;

/**
 * 继承BaseObserver防止其他module进行网络请求时。无法订阅
 * 避免.subscribe(new BaseObserver<TestBean>() {}-----出错
 * @param <T>
 */
public class IObserver<T> extends BaseObserver<T> {
    private OnRequestListener<T> listener;

    public IObserver(OnRequestListener<T> listener) {
        super();
        this.listener = listener;
    }

    @Override
    public void OnSuccess(T t) {
        listener.onSucceed(t);
    }

    @Override
    public void OnFail(Throwable e) {
        listener.onError(e);
    }

    @Override
    public void OnCompleted() {
        listener.OnCompleted();
    }

    @Override
    public void OnDisposable(Disposable d) {
        SubscriptionManager.getInstance().add(d);
    }
}
