package com.leehor.mvpmodule.Dipoable;

public interface OnRequestListener<T> {
    void onSucceed(T t);

    void onError(Throwable e);

    void OnCompleted();
}
