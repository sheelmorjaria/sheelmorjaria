package com.example.user.weekendassignmenttwo.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.weekendassignmenttwo.R;
import com.example.user.weekendassignmenttwo.model.MusicList;
import com.example.user.weekendassignmenttwo.model.Result;

import java.util.List;

/**
 * Created by sheel on 7/16/2017.
 */

public class MusicListAdapter extends RecyclerView.Adapter<MusicListAdapter.MyViewHolder> {
        List<MusicList> results;
        Context context;
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
//        holder.name.setText(results.get(position).getResults());
    }

    @Override
        public MusicListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
            return new MusicListAdapter.MyViewHolder(v);
        }

        public MusicListAdapter(List<MusicList> results, Context context) {
            this.results = results;
            this.context = context;
        }


        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView name;
            TextView collectionName;


            public MyViewHolder(View itemView) {
                super(itemView);
                name = (TextView) itemView.findViewById(R.id.name);
                collectionName=(TextView) itemView.findViewById(R.id.collectionname);

            }
        }
        @Override
        public int getItemCount() {
            return results.size();
        }

    }


