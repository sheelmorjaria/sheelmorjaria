package com.example.user.weekendassignmenttwo.MVP.Interactor;

import com.example.user.weekendassignmenttwo.model.MusicList;
import com.example.user.weekendassignmenttwo.model.Result;

import java.util.List;

/**
 * Created by sheel on 7/16/2017.
 */

public interface IResultListView extends MVPView {
    void onFetchDataInProgress();
    void onFetchDataSuccess(List<Result> resulted);
    void onFetchDataError(Throwable throwable);
    void onFetchDataCompleted();
}
