package com.example.user.apidemo.injection;

import com.example.user.apidemo.MainActivity;

import dagger.Component;

/**
 * Created by user on 7/18/2017.
 */
@PerActivity
@Component(dependencies = {PresenterModule.class})
public interface IPresenterComponent {
    void inject(MainActivity mainActivity);
//   void inject(CakeListPresenterImplementer cakeListPresenterImplementer);





}
