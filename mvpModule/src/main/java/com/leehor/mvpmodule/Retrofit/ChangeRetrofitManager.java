package com.leehor.mvpmodule.Retrofit;




import com.leehor.mvpmodule.base.BaseApi;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * yangyoupeng  on 2018/4/12.
 * <p>
 * rxjava+retrofit+框架封装
 */

public class ChangeRetrofitManager {
    /**
     * 保存一个retrofit的实例，通过吸（baseUrl来获取）
     */
    private HashMap<String, Retrofit> mRetrofitHashMap = new HashMap<>();

    private static final int DEFAULT_MILLISECONDS = 60000;             //默认的超时时间


    /**
     * 内部类单列设计模式
     */
    private ChangeRetrofitManager() {
    }

    private static class RetrofitManagerInstance {
        private final static ChangeRetrofitManager RETROFIT_MANAGER = new ChangeRetrofitManager();
    }

    public static ChangeRetrofitManager getInstance() {
        return RetrofitManagerInstance.RETROFIT_MANAGER;
    }

    /**
     * 获取retrofit的实例
     *
     * @return Retrofit
     */
    private Retrofit getRetrofit(String baseurl) {
        Retrofit retrofit;

        if (mRetrofitHashMap.containsKey(baseurl)) {
            retrofit = mRetrofitHashMap.get(baseurl);
        } else {
            retrofit = createrRetrofit(baseurl);
            mRetrofitHashMap.put(baseurl,retrofit);
        }

        return retrofit;
    }

    /**
     * 创建retrofit
     *
     * @return Retrofit
     */
    private Retrofit createrRetrofit(String baseurl) {

        OkHttpClient httpClient = new OkHttpClient().newBuilder()
                .readTimeout(DEFAULT_MILLISECONDS, TimeUnit.SECONDS)
                .connectTimeout(DEFAULT_MILLISECONDS, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_MILLISECONDS, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();

        return new Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient)
                .build();
    }


    /**
     *根据各模块业务接口 获取不同的retrofit service接口对象
     */
    public <T> T getRetrofitService(String BaseUrl,Class<T> cls) {

        return getRetrofit(BaseUrl).create(cls);
    }


}
