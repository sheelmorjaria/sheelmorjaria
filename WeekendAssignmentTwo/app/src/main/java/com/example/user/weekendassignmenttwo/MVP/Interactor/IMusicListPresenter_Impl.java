package com.example.user.weekendassignmenttwo.MVP.Interactor;

import com.example.user.weekendassignmenttwo.model.MusicList;
import com.github.pwittchen.reactivenetwork.library.rx2.ReactiveNetwork;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by user on 7/14/2017.
 */

public class IMusicListPresenter_Impl implements IMusicListPresenter {
    Interactor_Impl interactorImpl_;
    IMusicListView iMusicListView;
    @Override
    public void attachView(IMusicListView mvpView) {
        this.iMusicListView= mvpView;
    }

    @Override
    public void detachView() {

    }

    public IMusicListPresenter_Impl(Interactor_Impl interactorImpl_) {
        this.interactorImpl_ = interactorImpl_;
    }
    @Override
    public void performMusicListDisplay() {
        updateOperation();
    }
    public void updateOperation() {
        ReactiveNetwork.observeInternetConnectivity()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(@NonNull Boolean isConnectedToInternet) {
                        if (isConnectedToInternet) {
                            // do something with isConnectedToInternet value
                            interactorImpl_.getMusicList()
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribeOn(Schedulers.newThread())
                                    .subscribe(this::onSuccess, this::onError);
                        }
                    }

                    private void onError(Throwable throwable) {
                    }

                    private void onSuccess(List<MusicList> musicList) {
                        iMusicListView.onFetchDataSuccess(musicList);

                    }
                });
    }
}

