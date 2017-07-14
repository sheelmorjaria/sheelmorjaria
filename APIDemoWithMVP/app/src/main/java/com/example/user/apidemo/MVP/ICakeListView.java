package com.example.user.apidemo.MVP;

import com.example.user.apidemo.model.CakeModel;

import java.util.List;

/**
 * Created by user on 7/14/2017.
 */

public interface ICakeListView extends MVPView {
    void onFetchDataInProgress();
    void onFetchDataSuccess(List<CakeModel> modelList);
    void onFetchDataError(Throwable throwable);
    void onFetchDataCompleted();

}
