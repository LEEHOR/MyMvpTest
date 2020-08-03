package com.leehor.mvpmodule.Retrofit;




import com.leehor.mvpmodule.BuildConfig;
import com.leehor.mvpmodule.base.BaseApi;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;

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
    private HttpLoggingInterceptor loggingInterceptor;
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
     * 初始化 okhttp和retrofit
     *
     * @return Retrofit
     */
    private Retrofit createRetrofit(String baseurl) {
        if (BuildConfig.DEBUG){
            loggingInterceptor = new HttpLoggingInterceptor(new MyHttpLogging());
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        }
        OkHttpClient httpClient = new OkHttpClient().newBuilder()
                .readTimeout(DEFAULT_MILLISECONDS, TimeUnit.SECONDS)
                .connectTimeout(DEFAULT_MILLISECONDS, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_MILLISECONDS, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .addInterceptor(BuildConfig.DEBUG?loggingInterceptor:null)
                .build();

        return new Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient)
                .build();
    }

    /**
     * 获取retrofit的实例
     *
     * @return Retrofit
     */
    private Retrofit getRetrofit(String baseUrl) {
        Retrofit retrofit;
        if (mRetrofitHashMap.containsKey(baseUrl)) {
            retrofit = mRetrofitHashMap.get(baseUrl);
        } else {
            retrofit = createRetrofit(baseUrl);
            mRetrofitHashMap.put(baseUrl,retrofit);
        }

        return retrofit;
    }
    /**
     *根据各模块业务接口 获取不同的retrofit service接口对象
     */
    public <T> T getRetrofitService(String BaseUrl,Class<T> cls) {

        return getRetrofit(BaseUrl).create(cls);
    }


}
