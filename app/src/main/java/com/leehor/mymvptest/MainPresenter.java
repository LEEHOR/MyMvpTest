package com.leehor.mymvptest;

import com.leehor.mvpmodule.Dipoable.BaseObserver;
import com.leehor.mvpmodule.Dipoable.OnRequestListener;
import com.leehor.mvpmodule.Retrofit.RxSchedulers;
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

        MainModule.getInstance().MainRetrofit().getGSxin().compose(RxSchedulers.Obs_io_main())
                .compose(getView().bindLifeycle())
                .subscribe(new BaseObserver<BaseResponse<TestBean>>() {
                    @Override
                    public void OnDisposable() {

                    }

                    @Override
                    public void OnSuccess(BaseResponse<TestBean> testBeanBaseResponse) {

                    }

                    @Override
                    public void OnFail(Throwable e) {

                    }

                    @Override
                    public void OnCompleted() {

                    }
                });

    }
}
