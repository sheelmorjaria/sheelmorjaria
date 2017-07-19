package com.example.user.weekendassignmenttwo.MVP.Interactor;

import com.example.user.weekendassignmenttwo.model.MusicList;
import com.example.user.weekendassignmenttwo.model.Result;
import com.github.pwittchen.reactivenetwork.library.rx2.ReactiveNetwork;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by sheel on 7/16/2017.
 */

public class IResultListPresenter_Impl implements IResultListPresenter {
    Interactor_Impl interactorImpl_;
    IResultListView iResultListView;

    @Override
    public void attachView(IResultListView mvpView) {
        this.iResultListView = mvpView;

    }

    public IResultListPresenter_Impl(Interactor_Impl interactorImpl_) {
        this.interactorImpl_ = interactorImpl_;
    }

    @Override
    public void detachView() {

    }

    @Override
    public void performResultListDisplay() {
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
                            interactorImpl_.getResults()
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribeOn(Schedulers.newThread())
                                    .subscribe(this::onSuccess, this::onError);
                        }
                    }

                    private void onError(Throwable throwable) {
                    }

                    private void onSuccess(List<Result> resulted) {
                        iResultListView.onFetchDataSuccess(resulted);

                    }
                });
    }
}






