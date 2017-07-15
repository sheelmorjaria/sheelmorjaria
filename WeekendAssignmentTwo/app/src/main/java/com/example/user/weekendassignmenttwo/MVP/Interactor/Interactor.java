package com.example.user.weekendassignmenttwo.MVP.Interactor;

import com.example.user.weekendassignmenttwo.model.MusicList;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by user on 7/14/2017.
 */

public interface Interactor {

    Observable<List<MusicList>> getMusicList();

}
