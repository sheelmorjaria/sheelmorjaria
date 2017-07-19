package com.example.user.apidemo.injection;

import com.example.user.apidemo.MVP.Interactor.InteractorImplementor;

import dagger.Module;
import dagger.Provides;

/**
 * Created by user on 7/18/2017.
 */
@Module
public class PresenterModule {
//    @Singleton
    @Provides
    public InteractorImplementor getInteractor() {
        return new InteractorImplementor();
    }


    }

