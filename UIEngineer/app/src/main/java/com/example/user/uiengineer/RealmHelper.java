package com.example.user.uiengineer;

import android.util.Log;

import com.example.user.uiengineer.model.CustomerModel;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

/**
 * Created by user on 7/7/2017.
 */

public class RealmHelper {
    Realm realm;
    ArrayList<CustomerModel> arrayList;
    ArrayList<String> arrayListTwo;

    public RealmHelper(Realm realm) {
        this.realm = realm;
    }

    public void saveData(final CustomerModel customerModel){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealm(customerModel);
            }
        });
    }
    public ArrayList<String> getCustomers(){
        ArrayList<String> arrayList = new ArrayList<>();

        RealmResults<CustomerModel> c = realm.where(CustomerModel.class).findAll();
        for(CustomerModel customerModel: c ){
            arrayList.add(customerModel.getNameSave());
            arrayList.add(customerModel.getAgeSave());
        }
        return arrayList;
    }
//    public RealmList<CustomerModel> retrieveCustomers(){
//        customerModelRealmList = new RealmList<>();
//        RealmResults<CustomerModel> result = realm.where(CustomerModel.class).findAll();
//        customerModelRealmList.addAll(result);
//        return customerModelRealmList;
//    }
    public ArrayList<CustomerModel> findCustomers(){

        ArrayList<CustomerModel> arrayList = new ArrayList<>();

        RealmResults<CustomerModel> c = realm.where(CustomerModel.class).findAll();

        for(CustomerModel customerModel: c){
            arrayList.add(customerModel);
        }
        return arrayList;
    }
}

