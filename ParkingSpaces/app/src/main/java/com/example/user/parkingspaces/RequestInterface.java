package com.example.user.parkingspaces;

/**
 * Created by user on 7/20/2017.
 */


import com.example.user.parkingspaces.model.Constants;
import com.example.user.parkingspaces.model.ParkingSpaces;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RequestInterface {

    @GET(Constants.PARKINGLIST_API)
    Observable<List<ParkingSpaces>> getResult();

//    @GET(Constants.DETAILEDPARKINGLIST_API)
//    Observable<List<ParkingSpaces>> getResult(@Query("lat") Double lat, @Query("lng") Double lng);
}