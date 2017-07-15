package com.example.user.weekendassignmenttwo.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.weekendassignmenttwo.R;
import com.example.user.weekendassignmenttwo.model.MusicList;

import java.util.List;

/**
 * Created by user on 7/14/2017.
 */

public class RockMusicListAdapter extends RecyclerView.Adapter<RockMusicListAdapter.MyViewHolder> {
    List<MusicList> musicList;
    Context context;

    @Override
    public RockMusicListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RockMusicListAdapter.MyViewHolder holder, int position) {

    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView collectionName;
//        ImageView artworkURL;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            collectionName=(TextView) itemView.findViewById(R.id.description);
//            image =(ImageView) itemView.findViewById(R.id.image);
        }
    }
    @Override
    public int getItemCount() {
        return musicList.size();
    }
}
