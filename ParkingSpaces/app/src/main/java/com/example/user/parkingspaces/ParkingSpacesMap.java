package com.example.user.parkingspaces;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.example.user.parkingspaces.MVP.IMapView;
import com.example.user.parkingspaces.MVP.InteractorImpl;
import com.example.user.parkingspaces.MVP.MapPresenterImpl;
import com.example.user.parkingspaces.model.ParkingSpaces;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class ParkingSpacesMap extends FragmentActivity implements IMapView, OnMapReadyCallback {
    MapPresenterImpl mapPresenter;
    InteractorImpl interactor;
    GoogleMap mMap;



    public ParkingSpacesMap() {
        super();
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parking_map);
        interactor = new InteractorImpl();
        mapPresenter = new MapPresenterImpl(interactor);
        mapPresenter.attachView(this);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()

                .findFragmentById(R.id.mapView);

        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mapPresenter.checkOnline();
    }


    @Override
    public void onFetchDataInProgress() {

    }

    @Override
    public void onFetchDataSuccess(List<ParkingSpaces> parkingSpaces) {
        Log.i("name", parkingSpaces.toString());

        for (ParkingSpaces parkingSpace : parkingSpaces) {
            Marker marker;
            Log.i("name", parkingSpace.getName());

            LatLng latLng = new LatLng(Double.parseDouble(parkingSpace.getLat()),Double.parseDouble(parkingSpace.getLng()));
           marker   = mMap.addMarker(new MarkerOptions().position(latLng));
            if(parkingSpace.getIsReserved()){
             marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
            }
            else {
                marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));

            }
        }
    }

    @Override
    public void onFetchDataError(Throwable throwable) {
Log.i("error","error");
    }

    @Override
    public void onFetchDataCompleted() {

    }
}