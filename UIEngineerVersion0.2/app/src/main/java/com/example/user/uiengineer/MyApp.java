package com.example.user.uiengineer;

import android.app.Application;

import java.security.SecureRandom;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by user on 7/7/2017.
 */

public class MyApp extends Application {

    @Override
    public void onCreate() {
        byte[] key = new byte[64];
        new SecureRandom().nextBytes(key);
        Realm realm;

        //inti ext library
        super.onCreate();
        Realm.init(getApplicationContext());
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                //.encryptionKey(key)
                .name(Realm.DEFAULT_REALM_NAME)
                .schemaVersion(1)
                //delete old get new update db
                .deleteRealmIfMigrationNeeded()
                .build();
//        realm = Realm.getInstance(realmConfiguration);
        Realm.setDefaultConfiguration(realmConfiguration);

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        //realm.close();

    }
}
