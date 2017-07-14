package com.example.user.imdbmovies.movielist;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.imdbmovies.R;
import com.example.user.imdbmovies.movielist.adapter.MovieAdapter;
import com.example.user.imdbmovies.movielist.model.Constants;
import com.example.user.imdbmovies.movielist.model.MovieListModel;
import com.example.user.imdbmovies.movielist.model.Results;
import com.example.user.imdbmovies.movielist.service.ConnectionService;
import com.example.user.imdbmovies.movielist.service.RequestInterface;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class MoviesListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


RequestInterface requestInterface;
    MovieAdapter movieAdapter;
    RecyclerView myRecyclerView;
    List<Results> result;
    public MoviesListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragmentmovielist, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        requestInterface = ConnectionService.getConnection();
        requestInterface.getMoviesList(Constants.API_KEY)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccess, this::onError );
    }

    private void onSuccess(MovieListModel movies) {
        Log.i("movies", movies.getResults().toString());
        result = movies.getResults();
        movieAdapter= new MovieAdapter(result,getContext());
        myRecyclerView =(RecyclerView) getView().findViewById(R.id.recyclerview);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        myRecyclerView.setAdapter(movieAdapter);

    }



    private void onError(Throwable throwable) {
        Log.i("error","error");
    }





}

