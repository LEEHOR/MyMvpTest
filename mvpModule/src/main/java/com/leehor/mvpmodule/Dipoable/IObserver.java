package com.leehor.mvpmodule.Dipoable;

import io.reactivex.disposables.Disposable;

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
