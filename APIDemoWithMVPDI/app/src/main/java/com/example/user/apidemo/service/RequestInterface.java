package com.example.user.apidemo.service;

import com.example.user.apidemo.model.CakeModel;
import com.example.user.apidemo.model.Constants;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by user on 7/12/2017.
 */

public interface RequestInterface
{

 @GET(Constants.CAKELIST_API)
    Observable<List<CakeModel>> getCakelist();

}
