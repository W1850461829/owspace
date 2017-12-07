package com.navy.owspace.di.components;



import com.navy.owspace.di.modules.NetModule;
import com.navy.owspace.model.api.ApiService;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by Mr.Yangxiufeng
 * DATE 2016/10/27
 * owspace
 */
@Component(modules = NetModule.class)
@Singleton
public interface NetComponent {
    ApiService getApiService();
    OkHttpClient getOkHttp();
    Retrofit getRetrofit();
}
