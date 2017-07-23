//package com.example.user.parkingspaces;
//
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.FragmentActivity;
//
//import com.example.user.parkingspaces.MVP.InteractorImpl;
//import com.example.user.parkingspaces.model.ParkingSpaces;
//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.MapFragment;
//import com.google.android.gms.maps.OnMapReadyCallback;
//import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.MarkerOptions;
//
//import java.util.List;
//
//import io.reactivex.android.schedulers.AndroidSchedulers;
//import io.reactivex.schedulers.Schedulers;
//
//public class Maps extends FragmentActivity implements OnMapReadyCallback {
//
//    private GoogleMap mMap;
//    MapFragment mapFragment;
//    InteractorImpl interactor;
//    FetchAddressIntentService fetchAddressIntentService;
//
//
//    //    FetchAddressIntentService fetchAddressIntentService;
////    InteractorImpl interactor;
//    LatLng latLng = new LatLng(51.508676, -0.068944);
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_maps);
////        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
////        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
////                .findFragmentById(R.id.map);
////        mapFragment.getMapAsync(this);
//
////    public void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        fragmentManager.beginTransaction()
////                .add(R.id.container , this)
////                .commit();
////    fragmentManager = getFragmentManager();
//////        setContentView(R.layout.activity_maps);
//////        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//////                .findFragmentById(R.id.map);
////       mapFragment.getMapAsync(this);
//////        fetchAddressIntentService = new FetchAddressIntentService();
//////        latLng = fetchAddressIntentService.getLatLng();
////        Log.i("Location", String.valueOf(latLng));
//
////        interactor = new InteractorImpl();
//
////        mResultReceiver = new AddressResultReceiver(new Handler());
//
////        mLocationAddressTextView = (TextView) findViewById(R.id.location_address_view);
////        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
////        mFetchAddressButton = (Button) findViewById(R.id.fetch_address_button);
//
//    // Set defaults, then update using values stored in the Bundle.
////        mAddressRequested = false;
////        mAddressOutput = "";
//////        updateValuesFromBundle(savedInstanceState);
////
////        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
//
//    //  updateUIWidgets();
////    }
//
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.container);
//        interactor = new InteractorImpl();
//
//        MapFragment mapFragment = (MapFragment) getFragmentManager()
//                .findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
//        fetchAddressIntentService = new FetchAddressIntentService();
//        latLng = fetchAddressIntentService.getLatLng();
//
//
//////        latLng = fetchAddressIntentService.getLatLng();
//    }
//
//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        double lat = latLng.longitude;
//        double lng = latLng.latitude;
//        interactor.getParkingSpaces(lat, lng)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.newThread())
//                .subscribe(this::onSuccess, this::onError);
//    }
//
//    private void onError(Throwable throwable) {
//    }
//
//    private void onSuccess(List<ParkingSpaces> parkingSpaces) {
//
//        for (ParkingSpaces parkingSpace : parkingSpaces) {
//            Double lng;
//            Double lat;
//            lat = Double.parseDouble(parkingSpace.getLat());
//            lng = Double.parseDouble(parkingSpace.getLng());
//            LatLng latLng = new LatLng(lat, lng);
//
//
//            mMap.addMarker(new MarkerOptions().position(latLng));
//        }
//
////    @Override
////    public void onFetchDataInProgress() {
////
////    }
//
////    @Override
////    public void onFetchDataSuccess(List<ParkingSpaces> parkingSpaces) {
//////        for(ParkingSpaces parkingSpace: parkingSpaces)
//////        {
//////            Double lng;
//////            Double lat;
//////            lat = Double.parseDouble(parkingSpace.getLat());
//////            lng = Double.parseDouble(parkingSpace.getLng());
//////            LatLng latLng = new LatLng(lat, lng);
//////
//////
//////            mMap.addMarker(new MarkerOptions().position(latLng));
//////        }
////
////    }
////
////    @Override
////    public void onFetchDataError(Throwable throwable) {
//////realm
////
////    }
////
////    @Override
////    public void onFetchDataCompleted() {
////
////    }
////
//
//
////        interactor.getParkingSpaces(lat,lng)
////                                    .observeOn(AndroidSchedulers.mainThread())
////                                    .subscribeOn(Schedulers.newThread())
////                                    .subscribe(this::onSuccess, this::onError);
//
//
////    private void onSuccess(List<ParkingSpaces> parkingSpaces) {
////        for(ParkingSpaces parkingSpace: parkingSpaces)
////        {
////            Double lng;
////            Double lat;
////            lat = Double.parseDouble(parkingSpace.getLat());
////            lng = Double.parseDouble(parkingSpace.getLng());
////            LatLng latLng = new LatLng(lat, lng);
////
////            mMap.addMarker(new MarkerOptions().position(latLng));
////
////        }
//
////    }
//
////    private void onError(Throwable throwable) {
//////
//////        Log.i("","");
////    }
//
//
//        /**
//         * Manipulates the map once available.
//         * This callback is triggered when the map is ready to be used.
//         * This is where we can add markers or lines, add listeners or move the camera. In this case,
//         * we just add a marker near Sydney, Australia.
//         * If Google Play services is not installed on the device, the user will be prompted to install
//         * it inside the SupportMapFragment. This method will only be triggered once the user has
//         * installed Google Play services and returned to the app.
//         //     */
////    @Override
////    public void onMapReady(GoogleMap googleMap) {
////        mMap = googleMap;
////
////        // Add a marker in Sydney and move the camera
////        LatLng sydney = new LatLng(-34, 151);
////        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
////        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
////    }
//    }
//}
