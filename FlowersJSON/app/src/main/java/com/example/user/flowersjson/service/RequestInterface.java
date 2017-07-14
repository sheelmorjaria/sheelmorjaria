package com.example.user.flowersjson.service;

import com.example.user.flowersjson.model.Constants;
import com.example.user.flowersjson.model.FlowerModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by user on 7/14/2017.
 */

public interface RequestInterface
{

    @GET(Constants.FLOWERLIST_API)
    Observable<List<FlowerModel>> getFlowerList();

}
