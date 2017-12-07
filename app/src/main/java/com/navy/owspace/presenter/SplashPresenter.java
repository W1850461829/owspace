package com.navy.owspace.presenter;

import com.navy.owspace.app.OwspaceApplication;
import com.navy.owspace.model.api.ApiService;
import com.navy.owspace.model.entity.SplashEntity;
import com.navy.owspace.util.NetUtil;
import com.navy.owspace.util.OkHttpImageDownloader;
import com.navy.owspace.util.TimeUtil;
import com.orhanobut.logger.Logger;

import java.util.List;

import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/12/7.
 */

public class SplashPresenter implements SplashContract.Presenter {
    private ApiService apiService;

    public SplashPresenter(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void getSplash(String deviceiId) {
        String client = "android";
        String version = "1.3.0";
        Long time = TimeUtil.getCurrentSeconds();
        apiService.getSplash(client, version, time, deviceiId).
                subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(new Subscriber<SplashEntity>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(SplashEntity splashEntity) {
                        if (NetUtil.isWifi(OwspaceApplication.getInstance().getApplicationContext())) {
                            if (splashEntity != null) {
                                List<String> imgs = splashEntity.getImages();
                                for (String url : imgs) {
                                    OkHttpImageDownloader.download(url);
                                }

                            } else {
                                Logger.i("不是WIFI环境,就不去下载图片了");

                            }
                        }
                    }
                });

    }
}
