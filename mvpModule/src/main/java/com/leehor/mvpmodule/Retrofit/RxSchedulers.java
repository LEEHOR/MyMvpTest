package com.leehor.mvpmodule.Retrofit;




import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * yangyoupeng  on 2018/4/20.
 * <p>
 * 切换线程 与绑定rxlifeycle 生命周期
 */

public class RxSchedulers {

    public static <T> ObservableTransformer<T, T> observableIO2Main() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}