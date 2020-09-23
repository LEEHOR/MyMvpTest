package com.leehor.mvpmodule.Dipoable;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class SubscriptionManager implements SubscriptionHelper<Object> {
    public static SubscriptionManager subscriptionManager;
    private CompositeDisposable mDisposables;

    public SubscriptionManager() {
        if (mDisposables == null) {
            mDisposables = new CompositeDisposable();
        }
    }

    @Override
    public void add(Disposable disposable) {
        if (disposable == null) return;
        mDisposables.add(disposable);
    }

    @Override
    public void remove(Disposable disposable) {
        if (mDisposables != null) {
            mDisposables.remove(disposable);
        }
    }

    @Override
    public void clearAll() {
        if (mDisposables != null) {
            mDisposables.clear();
        }
    }

    @Override
    public void delete(Disposable disposable) {
        if (mDisposables != null) {
            mDisposables.delete(disposable);
        }
    }

    public static SubscriptionManager getInstance() {
        if (subscriptionManager == null) {
            synchronized (SubscriptionManager.class) {
                if (subscriptionManager == null) {
                    subscriptionManager = new SubscriptionManager();
                }
            }
        }
        return subscriptionManager;
    }
}
