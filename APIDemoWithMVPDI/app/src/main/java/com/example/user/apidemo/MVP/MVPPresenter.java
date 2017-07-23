package com.example.user.apidemo.MVP;

/**
 * Created by user on 7/14/2017.
 */
//tight coupling between view and presenter,one to one relationship
public interface MVPPresenter <V extends MVPView>{
    void attachView(V mvpView);
    void detachView();
}

