package com.example.user.uiengineer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.user.uiengineer.model.CustomerAdapter;
import com.example.user.uiengineer.model.CustomerModel;

import java.util.ArrayList;

import io.realm.Realm;

import static com.example.user.uiengineer.R.id.myRecyclerView;

public class DatabaseRecyclerView extends AppCompatActivity {
    RecyclerView myRecyclerView;
    RealmHelper realmHelper;
    ArrayList<CustomerModel> arrayList;
    Realm realm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CustomerModel modelParcel = (CustomerModel) getIntent().getParcelableExtra("customerModel");
        realm = Realm.getDefaultInstance();
        realmHelper = new RealmHelper(realm);
        arrayList = realmHelper.findCustomers();

        initializeRecyclerView();

    }
    public void initializeRecyclerView(){
        myRecyclerView =(RecyclerView)findViewById(R.id.myRecyclerView);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myRecyclerView.setAdapter(new CustomerAdapter(arrayList));

    }
}
