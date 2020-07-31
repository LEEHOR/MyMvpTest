package com.leehor.mymvptest;


import com.leehor.mvpmodule.base.BaseResponse;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface MainApiServer {

    @POST("/")
    Observable<BaseResponse<TestBean>> getGSxin();

    @FormUrlEncoded
    @POST("/")
    Observable<BaseResponse<TestBean>> getGSxin2(@FieldMap Map<String,String> map);
}
