package com.leehor.mymvptest;


import com.leehor.mvpmodule.Dipoable.IObserver;
import com.leehor.mvpmodule.Dipoable.OnRequestListener;
import com.leehor.mvpmodule.Retrofit.ChangeRetrofitManager;
import com.leehor.mvpmodule.base.BaseApi;
import com.leehor.mvpmodule.Dipoable.BaseModel;
import com.leehor.mvpmodule.base.BaseResponse;
import com.leehor.mvpmodule.base.IBaseView;

import java.util.Map;

import io.reactivex.Observer;

/**
 * 可以切换根地址的Retrofit
 */
public class MainModule extends BaseModel {
    private static MainModule instance;

    public  MainApiServer MainRetrofit() {
        return ChangeRetrofitManager.getInstance().getRetrofitService(BaseApi.getBaseUrl(),MainApiServer.class);
    }

    public static MainModule getInstance() {
        if (instance == null) {
            instance = new MainModule();
        }
        return instance;
    }

    public void getHttps(Map<String,String> map, OnRequestListener<BaseResponse<TestBean>> listener, IBaseView iBaseView) {
        Observer<BaseResponse<TestBean>> observer = new IObserver<>(listener);
        addSubcription(MainRetrofit().getGSxin2(map), observer,iBaseView);
    }
    public void getHttps(OnRequestListener<BaseResponse<TestBean>> listener,IBaseView iBaseView) {
        Observer<BaseResponse<TestBean>> observer = new IObserver<>(listener);
        addSubcription(MainRetrofit().getGSxin(), observer,iBaseView);
    }
}
