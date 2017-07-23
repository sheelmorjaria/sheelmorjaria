package com.example.user.parkingspaces.MVP;

import com.example.user.parkingspaces.model.ParkingSpaces;

import java.util.List;

/**
 * Created by user on 7/21/2017.
 */

public interface IMapView extends MVPView {
    void onFetchDataInProgress();

    void onFetchDataSuccess(List<ParkingSpaces> parkingSpaces);

    void onFetchDataError(Throwable throwable);

    void onFetchDataCompleted();
}
