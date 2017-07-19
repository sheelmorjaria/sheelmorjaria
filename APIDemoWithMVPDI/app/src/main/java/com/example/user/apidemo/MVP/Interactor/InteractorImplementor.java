package com.example.user.apidemo.MVP.Interactor;

import com.example.user.apidemo.model.CakeModel;
import com.example.user.apidemo.model.Constants;
import com.example.user.apidemo.service.RequestInterface;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by user on 7/14/2017.
 */

public class InteractorImplementor implements  Interactor {
    static OkHttpClient okHttpClient;
    static Retrofit retrofit;
    RequestInterface requestInterface;
    @Override
    public Observable<List<CakeModel>> getCakeList() {
        return requestInterface.getCakelist();
    }

    public InteractorImplementor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
       requestInterface = retrofit.create(RequestInterface.class);
    }

}
