package com.leehor.mvpmodule.Retrofit;

import com.leehor.mvpmodule.base.IBaseView;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 封装线程管理和订阅的过程
 */
public class BaseModel {
    protected <T> void addSubcription(Observable<T> ob, Observer<T> callback, IBaseView iBaseView) {
        if (callback != null && ob != null) {
            ob.subscribeOn(Schedulers.io())
                    .unsubscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .compose(iBaseView.bindLifeycle())
                    .subscribe(callback);
        }
    }
}
