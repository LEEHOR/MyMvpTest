package com.leehor.mvpmodule.Dipoable;

import io.reactivex.disposables.Disposable;

public interface SubscriptionHelper<T> {
    void add(Disposable subscription);

    void remove(Disposable t);

    void clearAll();

    void delete(Disposable disposable);
}
