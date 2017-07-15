package com.example.user.weekendassignmenttwo.MVP.Interactor;

/**
 * Created by user on 7/14/2017.
 */

public interface MVPPresenter <V extends MVPView>{
    void attachView(V mvpView);
    void detachView();
}
