package com.example.user.apidemo.MVP;

import com.example.user.apidemo.MVP.Interactor.InteractorImplementor;
import com.example.user.apidemo.model.CakeModel;
import com.github.pwittchen.reactivenetwork.library.rx2.ReactiveNetwork;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by user on 7/14/2017.
 */

public class CakeListPresenterImplementer implements ICakeListPresenter {
    InteractorImplementor interactorImplementor_;
    ICakeListView iCakeListView;
    @Override
    public void attachView(ICakeListView mvpView) {
        this.iCakeListView= mvpView;
    }

    @Override
    public void detachView() {

    }

    public CakeListPresenterImplementer(InteractorImplementor interactorImplementor_) {
        this.interactorImplementor_ = interactorImplementor_;
    }
    @Override
    public void performCakeListDisplay() {
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
                                       interactorImplementor_.getCakeList()
                                               .observeOn(AndroidSchedulers.mainThread())
                                               .subscribeOn(Schedulers.newThread())
                                               .subscribe(this::onSuccess, this::onError);
                                   }
                               }

                    private void onError(Throwable throwable) {
                    }

                    private void onSuccess(List<CakeModel> cakeModels) {
                        iCakeListView.onFetchDataSuccess(cakeModels);

                    }
                });
    }
}






//                            Toast.makeText(this, "network connected", Toast.LENGTH_LONG).show();
//                        } else {
                            //load data from realm

//                            Toast.makeText(MainActivity.this, "network unavailable", Toast.LENGTH_LONG).show();
//                            if (realm != null) {
//                                realm = Realm.getDefaultInstance();
//                                results = realm.where(CakeModel.class).findAll();
//                                List<CakeModel> listCakes = realm.copyFromRealm(results);
//                                cakeAdapter = new CakesAdapter(listCakes, getApplicationContext());
////                                myRecyclerView = (RecyclerView) findViewById(R.id.myRecyclerView);
////                            myRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
////                            myRecyclerView.setAdapter(cakeAdapter);
//                            }
//                        }
//                    }
//                });

                        

                   
    