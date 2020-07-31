package com.leehor.basemvp.Retrofit;



import com.leehor.basemvp.base.IBaseView;

import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * yangyoupeng  on 2018/4/20.
 * <p>
 * 切换线程 与绑定rxlifeycle 生命周期
 */

public class RxSchedulers {

    public static <T> ObservableTransformer<T, T> observableIO2Main(IBaseView baseView) {
        return upstream -> upstream.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(baseView.bindLifeycle());
    }
}