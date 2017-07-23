package com.example.user.parkingspaces.MVP;

/**
 * Created by user on 7/21/2017.
 */

public interface MVPPresenter <V extends MVPView>{
    void attachView(V mvpView);
    void detachView();
}