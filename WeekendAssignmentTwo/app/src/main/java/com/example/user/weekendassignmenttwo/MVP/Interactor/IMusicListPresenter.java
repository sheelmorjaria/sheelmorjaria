package com.example.user.weekendassignmenttwo.MVP.Interactor;

import com.example.user.weekendassignmenttwo.model.MusicList;

import java.util.List;

/**
 * Created by user on 7/14/2017.
 */

public interface IMusicListPresenter extends MVPPresenter<IMusicListView>
{
    void performMusicListDisplay();
    void performResultsListDisplay();

}
