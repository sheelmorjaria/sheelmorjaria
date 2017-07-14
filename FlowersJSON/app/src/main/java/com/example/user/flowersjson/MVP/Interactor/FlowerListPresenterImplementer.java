package com.example.user.flowersjson.MVP.Interactor;

import com.example.user.flowersjson.model.FlowerModel;
import com.github.pwittchen.reactivenetwork.library.rx2.ReactiveNetwork;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by user on 7/14/2017.
 */

public class FlowerListPresenterImplementer implements  IFlowerListPresenter{
    InteractorImplementer interactorImplementer_;
    IFlowerListView iFlowerListView;

    @Override
    public void attachView(IFlowerListView mvpView) {
        this.iFlowerListView= mvpView;
    }

    @Override
    public void detachView() {

    }

    public FlowerListPresenterImplementer(InteractorImplementer interactorImplementer_) {
        this.interactorImplementer_ = interactorImplementer_;
    }

    public void performFlowerListDisplay() {
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
                            interactorImplementer_.getFlowerList()
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribeOn(Schedulers.newThread())
                                    .subscribe(this::onSuccess, this::onError);
                        }
                    }

                    private void onError(Throwable throwable) {
                    }

                    private void onSuccess(List<FlowerModel> flowerModels) {
                        iFlowerListView.onFetchDataSuccess(flowerModels);

                    }
                });
    }
}
