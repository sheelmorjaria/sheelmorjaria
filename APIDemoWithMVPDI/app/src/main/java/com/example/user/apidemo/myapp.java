package com.example.user.apidemo;

import android.app.Application;

import com.example.user.apidemo.injection.DaggerIPresenterComponent;
import com.example.user.apidemo.injection.IPresenterComponent;

/**
 * Created by user on 7/14/2017.
 */

public class myapp extends Application {
    IPresenterComponent iPresenterComponent;
    public IPresenterComponent getiPresenterComponent() {
        return iPresenterComponent;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        iPresenterComponent = DaggerIPresenterComponent.create();
    }
}
