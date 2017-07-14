package com.example.user.flowersjson.MVP.Interactor;

import com.example.user.flowersjson.model.FlowerModel;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by user on 7/14/2017.
 */

public interface Interactor {
    public Observable<List<FlowerModel>> getFlowerList();
}
