package com.example.user.weekendassignmenttwo.service;

import com.example.user.weekendassignmenttwo.model.Constants;
import com.example.user.weekendassignmenttwo.model.MusicList;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by user on 7/14/2017.
 */

public interface RequestInterface {
    @GET(Constants.MUSICLIST_API)
    Observable<List<MusicList>> getMusicList();

//    @GET(Constants.MUSICLIST_API)
//    Observable<List<Result>> getArtistName;


}
