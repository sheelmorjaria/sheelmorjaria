package com.example.user.flowersjson;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.user.flowersjson.MVP.Interactor.FlowerListPresenterImplementer;
import com.example.user.flowersjson.MVP.Interactor.IFlowerListView;
import com.example.user.flowersjson.MVP.Interactor.InteractorImplementer;
import com.example.user.flowersjson.adapter.FlowerAdapter;
import com.example.user.flowersjson.model.FlowerModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IFlowerListView {
    FlowerListPresenterImplementer flowerListPresenterImplementer;
    InteractorImplementer interactorImplementer;
    FlowerAdapter flowerAdapter;
    RecyclerView myRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);
        interactorImplementer = new InteractorImplementer();
        myRecyclerView = (RecyclerView) findViewById(R.id.myRecyclerView);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        flowerListPresenterImplementer = new FlowerListPresenterImplementer(interactorImplementer);
        flowerListPresenterImplementer.attachView(this);
        flowerListPresenterImplementer.performFlowerListDisplay();
    }

    @Override
    public void onFetchDataInProgress() {

    }

    @Override
    public void onFetchDataSuccess(List<FlowerModel> modelList) {
        flowerAdapter =  new FlowerAdapter(modelList,getApplicationContext());
        myRecyclerView.setAdapter(flowerAdapter);
    }

    @Override
    public void onFetchDataError(Throwable throwable) {

    }

    @Override
    public void onFetchDataCompleted() {

    }
}
