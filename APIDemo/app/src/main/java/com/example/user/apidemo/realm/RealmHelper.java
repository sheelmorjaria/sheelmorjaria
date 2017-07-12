package com.example.user.apidemo.realm;

import com.example.user.apidemo.model.CakeModel;

import java.util.ArrayList;

import io.realm.Realm;

/**
 * Created by user on 7/7/2017.
 */

public class RealmHelper {
    Realm realm;
    ArrayList<CakeModel> arrayList;


    public RealmHelper(Realm realm) {
        this.realm = realm;
    }

    public void saveData(final CakeModel cakeModel) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(cakeModel);
            }
        });
        realm.close();
        }


}
