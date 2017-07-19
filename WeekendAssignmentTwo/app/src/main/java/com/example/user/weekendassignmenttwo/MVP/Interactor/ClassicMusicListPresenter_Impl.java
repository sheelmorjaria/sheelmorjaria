package com.example.user.weekendassignmenttwo.MVP.Interactor;

import android.util.Log;
import android.widget.Toast;

import com.example.user.weekendassignmenttwo.ClassicFragment;
import com.example.user.weekendassignmenttwo.adapters.ResultListAdapter;
import com.example.user.weekendassignmenttwo.model.MusicList;
import com.example.user.weekendassignmenttwo.model.Result;
import com.example.user.weekendassignmenttwo.realm.RealmHelper;
import com.github.pwittchen.reactivenetwork.library.rx2.ReactiveNetwork;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by sheel on 7/16/2017.
 */

public class ClassicMusicListPresenter_Impl implements IMusicListPresenter {
    Interactor_Impl interactorImpl_;
    IMusicListView iMusicListView;
    IResultListView iResultListView;
    Realm realm;
    RealmHelper realmHelper;
    RealmResults<MusicList> resultsMusic;
    RealmResults<Result> resultsResult;
    List<MusicList> musicListResults;

    public ClassicMusicListPresenter_Impl(Interactor_Impl interactorImpl_) {
        this.interactorImpl_ = interactorImpl_;
    }

    @Override
    public void attachView(IMusicListView mvpView) {
        this.iMusicListView = mvpView;

    }

    @Override
    public void detachView() {

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
                            interactorImpl_.getClassicResults()
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribeOn(Schedulers.newThread())
                                    .subscribe(this::onSuccess, this::onError);
                        } else {
                            //load data from realm

                            if (realm != null) {
                                realm = Realm.getDefaultInstance();
                                resultsMusic = realm.where(MusicList.class).findAll();
                                musicListResults = realm.copyFromRealm(resultsMusic);


                            }
                        }
                    }

                    private void onError(Throwable throwable) {
                        Log.i("Error", "ERROR");
                    }

                    private void onSuccess(MusicList musicData) {

                        iMusicListView.onFetchDataSuccess(musicData);
                        //if no  network save api data to realm

                        realmHelper = new RealmHelper(realm);


                        realmHelper.saveMusicData(musicData);

                    }
                });
    }




    public void performResultsListDisplay() {
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
                        } else {
                            //load data from realm

                            if (realm != null) {
                                realm = Realm.getDefaultInstance();
                                resultsResult = realm.where(Result.class).findAll();
                                List<Result> listResults = realm.copyFromRealm(resultsResult);

                            }
                        }
                    }

                    private void onError(Throwable throwable) {
                        Log.i("ERROR", "Error");

                    }

                    private void onSuccess(List<Result> rslt) {


                        iResultListView.onFetchDataSuccess(rslt);
                        //if no  network save api data to realm

                        realmHelper = new RealmHelper(realm);

                        for (Result result : rslt) {
                            realmHelper.saveResultData(result);
                        }
                    }
                });


    }
}
  