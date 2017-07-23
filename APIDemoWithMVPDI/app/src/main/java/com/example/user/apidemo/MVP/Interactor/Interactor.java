package com.example.user.apidemo.MVP.Interactor;

import com.example.user.apidemo.model.CakeModel;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by user on 7/14/2017.
 */

public interface Interactor  {
Observable<List<CakeModel>> getCakeList();
}
