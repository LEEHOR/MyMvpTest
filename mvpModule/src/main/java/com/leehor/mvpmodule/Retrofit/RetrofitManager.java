package com.leehor.mvpmodule.Retrofit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {
    private volatile static RetrofitManager retrofitManager;
    private Retrofit retrofit;

    //无参的单利模式
    public static RetrofitManager getSingleton() {
        if (retrofitManager == null) {
            synchronized (RetrofitManager.class) {
                retrofitManager = new RetrofitManager();
            }
        }
        return retrofitManager;
    }


    //无参的构造方法
    private RetrofitManager() {
        initRetrofitManager();
    }

    //构造方法创建Retrofit实例
    private void initRetrofitManager() {
        retrofit = new Retrofit.Builder().baseUrl("https://www.baidu.com/")//需要配置根路径
                .addConverterFactory(GsonConverterFactory.create())//请求的结果转为实体类
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//适配RxJava2.0
                .build();
    }

    /**
     *根据各模块业务接口 获取不同的retrofit service接口对象
     */
    public <T>T ApiService(Class<T> c) {
        return retrofit.create(c);
    }
}
