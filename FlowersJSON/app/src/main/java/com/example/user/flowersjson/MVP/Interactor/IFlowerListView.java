package com.example.user.flowersjson.MVP.Interactor;

import com.example.user.flowersjson.model.FlowerModel;

import java.util.List;

/**
 * Created by user on 7/14/2017.
 */

public interface IFlowerListView extends MVPView {
        void onFetchDataInProgress();
        void onFetchDataSuccess(List<FlowerModel> modelList);
        void onFetchDataError(Throwable throwable);
        void onFetchDataCompleted();

    }
