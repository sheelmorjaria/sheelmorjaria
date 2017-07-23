package com.example.user.apidemo.injection;

import com.example.user.apidemo.model.Constants;
import com.example.user.apidemo.service.RequestInterface;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by user on 7/18/2017.
 */
@Module
public class NetworkModule {

    public static final String NAME_BASE_URL = "https://gist.githubusercontent.com/hart88/";
    @Provides
    @Named(NAME_BASE_URL)
    String provideBaseUrlString() {
        return Constants.BASE_URL;
    }
    @Provides
    @Singleton
    Converter.Factory provideGsonConverter() {
        return GsonConverterFactory.create();
    }
    @Provides
    @Singleton
    Retrofit provideRetrofit(Converter.Factory converter, @Named(NAME_BASE_URL) String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(provideBaseUrlString())
                .addConverterFactory(provideGsonConverter())
                .addCallAdapterFactory(provideRxJava2CallAdapterFactory())
                .client(provideOkHttpClient())
                .build();
    }
    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(){return new OkHttpClient.Builder()
        .addInterceptor(providehttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build();}
    @Provides
    @Singleton
    RequestInterface provideRequest(Retrofit retrofit) {
        return retrofit.create(RequestInterface.class);
    }
    @Provides
    @Singleton
    HttpLoggingInterceptor providehttpLoggingInterceptor(){return new HttpLoggingInterceptor();
    }
    @Provides
    @Singleton
    RxJava2CallAdapterFactory provideRxJava2CallAdapterFactory(){return RxJava2CallAdapterFactory.create();}
}