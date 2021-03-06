package com.example.user.imdbmovies.movielist.service;

import com.example.user.imdbmovies.movielist.model.MovieListModel;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by user on 7/13/2017.
 */

public interface RequestInterface {
    @GET("movie/top_rated")
   Observable<MovieListModel> getMoviesList(@Query("api_key") String apikey);
}
