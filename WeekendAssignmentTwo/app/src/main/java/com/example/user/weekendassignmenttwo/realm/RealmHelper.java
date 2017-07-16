package com.example.user.weekendassignmenttwo.realm;

import com.example.user.weekendassignmenttwo.model.MusicList;
import com.example.user.weekendassignmenttwo.model.Result;


import java.util.List;

import io.realm.Realm;


/**
 * Created by sheel on 7/16/2017.
 */


public class RealmHelper {
    Realm realm;


    public RealmHelper(Realm realm) {
        this.realm = realm;
    }

    public void saveMusicData(final MusicList music) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealm(music);
            }
        });
        realm.close();
    }
    public void saveResultData(final Result result) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealm(result);
            }
        });
        realm.close();
    }

}
