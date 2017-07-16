package com.example.user.weekendassignmenttwo.MVP.Interactor;

import com.example.user.weekendassignmenttwo.model.Constants;
import com.example.user.weekendassignmenttwo.model.MusicList;
import com.example.user.weekendassignmenttwo.model.Result;
import com.example.user.weekendassignmenttwo.service.RequestInterface;
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

public class Interactor_Impl implements Interactor{
    RequestInterface requestInterface;
    static OkHttpClient okHttpClient;
    static Retrofit retrofit;

    @Override
    public Observable<MusicList> getPopResults(){return requestInterface.getPopMusicResults();}
    public Observable<MusicList> getClassicResults(){return requestInterface.getClassicMusicResults();}
    public Observable<MusicList> getRockResults(){return requestInterface.getRockMusicResults();}
    public Observable<List<Result>> getResults(){return  requestInterface.getResults();}
    public Interactor_Impl() {
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