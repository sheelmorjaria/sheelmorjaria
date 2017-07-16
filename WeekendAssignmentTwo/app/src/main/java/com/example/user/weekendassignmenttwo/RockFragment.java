package com.example.user.weekendassignmenttwo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.weekendassignmenttwo.MVP.Interactor.PopMusicListPresenter_Impl;
import com.example.user.weekendassignmenttwo.MVP.Interactor.IMusicListView;
import com.example.user.weekendassignmenttwo.MVP.Interactor.Interactor_Impl;
import com.example.user.weekendassignmenttwo.MVP.Interactor.RockMusicListPresenter_Impl;
import com.example.user.weekendassignmenttwo.adapters.ResultListAdapter;
import com.example.user.weekendassignmenttwo.model.MusicList;
import com.example.user.weekendassignmenttwo.model.Result;

import java.util.List;

/**
 * Created by sheel on 7/16/2017.
 */


public class RockFragment extends Fragment implements IMusicListView {
    ResultListAdapter resultListAdapter;
    Interactor_Impl interactor_;
    RecyclerView myRecyclerView;
    RockMusicListPresenter_Impl iMusicListPresenter_;
    List<Result> resulted;
    public RockFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment,container,false);
        return view;
    }

    @Override
    public void onFetchDataInProgress() {

    }

    @Override
    public void onFetchDataSuccess(MusicList musicList) {
        Log.i("music",musicList.toString());

        resulted = musicList.getResults();

        resultListAdapter = new ResultListAdapter(resulted,getContext());
        myRecyclerView.setAdapter(resultListAdapter);

    }

    @Override
    public void onFetchDataError(Throwable throwable) {

    }

    @Override
    public void onFetchDataCompleted() {

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        interactor_ = new Interactor_Impl();
        myRecyclerView = (RecyclerView) getView().findViewById(R.id.recyclerview);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        iMusicListPresenter_= new RockMusicListPresenter_Impl(interactor_);
        iMusicListPresenter_.attachView(this);
        iMusicListPresenter_.performMusicListDisplay();
    }
}

