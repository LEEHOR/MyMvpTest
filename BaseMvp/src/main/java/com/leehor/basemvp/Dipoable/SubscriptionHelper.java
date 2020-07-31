package com.leehor.basemvp.Dipoable;

import io.reactivex.disposables.Disposable;

public interface SubscriptionHelper<T> {
    void add(Disposable subscription);

    void cancel(Disposable t);

    void cancelall();
}
