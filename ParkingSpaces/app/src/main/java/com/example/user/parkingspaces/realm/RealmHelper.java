package com.example.user.parkingspaces.realm;

/**
 * Created by user on 7/23/2017.
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
