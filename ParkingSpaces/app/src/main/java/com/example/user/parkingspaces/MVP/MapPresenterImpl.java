package com.example.user.parkingspaces.MVP;

import android.util.Log;

import com.example.user.parkingspaces.model.ParkingSpaces;
import com.github.pwittchen.reactivenetwork.library.rx2.ReactiveNetwork;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by user on 7/21/2017.
 */

public class MapPresenterImpl implements IMapPresenter {
    IMapView iMapView;
    InteractorImpl interactor;
    List<ParkingSpaces> spacesList;
//    FetchAddressIntentService fetchAddressIntentService;
//    LatLng latLng= fetchAddressIntentService.getLatLng();

    //        double lat = latLng.longitude;
//        double lng = latLng.latitude;

//    Realm realm;
//    RealmHelper realmHelper;


    @Override
    public void attachView(IMapView mvpView) {
        this.iMapView = mvpView;
    }

    @Override
    public void detachView() {

    }

    public MapPresenterImpl(InteractorImpl interactor) {
        this.interactor = interactor;
//        fetchAddressIntentService = new FetchAddressIntentService();
//        latLng = fetchAddressIntentService.getLatLng();
    }

//

    public void checkOnline(){
        ReactiveNetwork.observeInternetConnectivity()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(@NonNull Boolean isConnectedToInternet) {
                        if (isConnectedToInternet) {
                            performMapDisplay();
                        }
                    }
                });
    }
    @Override
    public void performMapDisplay() {

                            interactor.getParkingSpaces()
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribeOn(Schedulers.newThread())
                                    .subscribe(this::onSuccess, this::onError);

                    }
                    private void onError(Throwable throwable) {

                    }


                    private void onSuccess(List<ParkingSpaces> parkingSpaces) {
                        spacesList = parkingSpaces;
                        Log.i("tests", spacesList.toString());
                        iMapView.onFetchDataSuccess(parkingSpaces);
                    }


    }








