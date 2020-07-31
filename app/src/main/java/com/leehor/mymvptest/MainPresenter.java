package com.leehor.mymvptest;

import com.leehor.mvpmodule.Dipoable.OnRequestListener;
import com.leehor.mvpmodule.base.BaseResponse;

public class MainPresenter extends MainContract.Presenter {

    @Override
    public void startHttp() {

      /*
        方法一
       */
        MainModule.getInstance().getHttps(new OnRequestListener<BaseResponse<TestBean>>() {
            @Override
            public void onSucceed(BaseResponse<TestBean> baseResponse) {
                TestBean data = baseResponse.getData();
                getView().Success();
            }

            @Override
            public void onError(Throwable e) {
                getView().Failure();
            }

            @Override
            public void OnCompleted() {

            }
        },getView());

        /*
            方法2
         */
//        Observable<BaseResponse<TestBean>> gSxin = RetrofitManager.getSingleton().ApiService(MainApiServer.class).getGSxin();
//        gSxin.compose(RxSchedulers.observableIO2Main())
//                .subscribe(new BaseObserver<TestBean>() {
//                    @Override
//                    public void OnSuccess(BaseResponse<TestBean> t) {
//
//                    }
//
//                    @Override
//                    public void OnFail() {
//
//                    }
//
//                    @Override
//                    public void OnCompleted() {
//
//                    }
//                });
    }
}
