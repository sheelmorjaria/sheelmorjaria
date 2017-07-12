package com.example.user.apidemo;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.user.apidemo.adapters.CakesAdapter;
import com.example.user.apidemo.model.CakeModel;
import com.example.user.apidemo.realm.RealmHelper;
import com.example.user.apidemo.service.ConnectionService;
import com.example.user.apidemo.service.RequestInterface;
import com.github.pwittchen.reactivenetwork.library.rx2.ReactiveNetwork;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
private RequestInterface requestInterface;
    RecyclerView myRecyclerView;
    CakesAdapter cakeAdapter;
    Realm realm;
    RealmHelper realmHelper;
    RealmResults<CakeModel> results;
    private SwipeRefreshLayout swipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);
        requestInterface = ConnectionService.getConnection();
        realm = Realm.getDefaultInstance();
        realmHelper = new RealmHelper(realm);
        swipeRefreshLayout=(SwipeRefreshLayout)findViewById(R.id.swipeRefreshCakes);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                updateOperation();
            }
        });

    }

    public void updateOperation(){
        ReactiveNetwork.observeInternetConnectivity()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Boolean>(){
                    @Override public void accept(@NonNull Boolean isConnectedToInternet) {
                        if(isConnectedToInternet){
                            // do something with isConnectedToInternet value
                            requestInterface.getCakelist()
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribeOn(Schedulers.newThread())
                                    .subscribe(MainActivity.this::onSuccess,MainActivity.this::onError);
                            Toast.makeText(MainActivity.this,"network connected",Toast.LENGTH_LONG).show();
                        }
                        else{
                            //load data from realm

                            Toast.makeText(MainActivity.this, "network unavailable",Toast.LENGTH_LONG).show();
                            if(realm!=null){
                               realm =Realm.getDefaultInstance();
                                results = realm.where(CakeModel.class).findAll();
                                List<CakeModel> listCakes = realm.copyFromRealm(results);
                                cakeAdapter = new CakesAdapter(listCakes, getApplicationContext());
                                myRecyclerView =(RecyclerView)findViewById(R.id.myRecyclerView);
                                myRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                                myRecyclerView.setAdapter(cakeAdapter);

                            }
                        }
                    }
                });
    }
    public void initRecyclerView(CakesAdapter cakeAdapter){
        myRecyclerView =(RecyclerView)findViewById(R.id.myRecyclerView);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        myRecyclerView.setAdapter(cakeAdapter);
    }

    private void onSuccess(List<CakeModel> cakesModels) {
        //call recyclerview
        //if no  network save api data to realm

        cakeAdapter = new CakesAdapter(cakesModels,getApplicationContext());
            initRecyclerView(cakeAdapter);
        realmHelper = new RealmHelper(realm);

      for(CakeModel cakeModel: cakesModels){
            realmHelper.saveData(cakeModel);
       }

    }


    private void onError(Throwable throwable){

    }
}
