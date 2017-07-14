package com.example.user.flowersjson.MVP.Interactor;

/**
 * Created by user on 7/14/2017.
 */

        import com.example.user.flowersjson.model.Constants;
        import com.example.user.flowersjson.model.FlowerModel;
        import com.example.user.flowersjson.service.RequestInterface;
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

public class InteractorImplementer implements Interactor {
    static OkHttpClient okHttpClient;
    static Retrofit retrofit;
    RequestInterface requestInterface;
    @Override
    public Observable<List<FlowerModel>> getFlowerList(){
        return requestInterface.getFlowerList();
    }



    public InteractorImplementer() {
        HttpLoggingInterceptor httpFlowerModelLoggingInterceptor = new HttpLoggingInterceptor();
        httpFlowerModelLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpFlowerModelLoggingInterceptor)
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
