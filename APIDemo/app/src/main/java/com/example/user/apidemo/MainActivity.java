package com.example.user.apidemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.user.apidemo.adapters.CakesAdapter;
import com.example.user.apidemo.model.CakesModel;
import com.example.user.apidemo.service.ConnectionService;
import com.example.user.apidemo.service.RequestInterface;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
private RequestInterface requestInterface;
    RecyclerView myRecyclerView;
    CakesAdapter cakeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);
        requestInterface= ConnectionService.getConnection();
        requestInterface.getCakelist()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(this::onSuccess, this::onError);
    }

    private void onSuccess(List<CakesModel> cakesModels) {
        //call recyclerview
            cakeAdapter =new CakesAdapter(cakesModels, getApplicationContext());
            myRecyclerView =(RecyclerView)findViewById(R.id.myRecyclerView);
            myRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            myRecyclerView.setAdapter(cakeAdapter);


    }
    private void onError(Throwable throwable){

    }
}
