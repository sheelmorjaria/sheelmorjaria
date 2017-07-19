package com.example.user.weekendassignmenttwo.service;

import com.example.user.weekendassignmenttwo.model.Constants;
import com.example.user.weekendassignmenttwo.model.MusicList;
import com.example.user.weekendassignmenttwo.model.Result;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by user on 7/14/2017.
 */

public interface RequestInterface {
//    @GET(Constants.MUSICLIST_API)
//    Observable<List<Result>> getResults();
    @GET(Constants.CLASSICMUSICLIST_API)
    Observable<MusicList> getClassicMusicResults();
    @GET(Constants.POPMUSICLIST_API)
    Observable<MusicList> getPopMusicResults();
    @GET(Constants.ROCKMUSICLIST_API)
    Observable<MusicList> getRockMusicResults();
    @GET(Constants.CLASSICMUSICLIST_API)
    Observable<List<Result>> getResults();

//    @GET(Constants.MUSICLIST_API)
//    Observable<List<Result>> getArtistName;


}
