package com.example.user.parkingspaces.MVP;

import com.example.user.parkingspaces.model.ParkingSpaces;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by user on 7/20/2017.
 */

public interface  Interactor {
    Observable<List<ParkingSpaces>> getParkingSpaces();
}
