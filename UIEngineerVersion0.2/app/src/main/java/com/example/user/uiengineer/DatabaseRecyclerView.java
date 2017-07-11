package com.example.user.uiengineer;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.user.uiengineer.model.CustomerAdapter;
import com.example.user.uiengineer.model.CustomerModel;

import java.util.ArrayList;

import io.realm.Realm;

public class DatabaseRecyclerView extends AppCompatActivity {
    RecyclerView myRecyclerView;
    RealmHelper realmHelper;
    ArrayList<CustomerModel> arrayList;
    CustomerModel modelParcel;
    Bitmap bmp;
    CustomerAdapter customerAdapter;
    byte[] photoByteArray;
    Realm realm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_results);

      modelParcel = getIntent().getParcelableExtra("customerModel");

        try {
            photoByteArray = modelParcel.getPhotoByteArray();
        }catch(NullPointerException ex)
        {
            ex.printStackTrace();
        }
        try{
            bmp = getBitmap(photoByteArray);

        }catch (Exception exception)
        {
            exception.printStackTrace();
        }
        realm = Realm.getDefaultInstance();
        realmHelper = new RealmHelper(realm);
        arrayList = realmHelper.findCustomers();
        customerAdapter = new CustomerAdapter(arrayList);
        initializeRecyclerView();
    }
    public Bitmap getBitmap(byte[] bitmap) {
        return BitmapFactory.decodeByteArray(bitmap , 0, bitmap.length);
    }
    public void initializeRecyclerView(){
        myRecyclerView =(RecyclerView)findViewById(R.id.myRecyclerView);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myRecyclerView.setAdapter(customerAdapter);

    }
}
