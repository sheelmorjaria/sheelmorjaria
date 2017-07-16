package com.example.user.weekendassignmenttwo.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.weekendassignmenttwo.R;
import com.example.user.weekendassignmenttwo.model.Result;

import java.util.List;

/**
 * Created by user on 7/14/2017.
 */

public class ResultListAdapter extends RecyclerView.Adapter<ResultListAdapter.MyViewHolder> {
    List<Result> results;
    Context context;

    @Override
    public ResultListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        return new MyViewHolder(v);
    }

    public ResultListAdapter(List<Result> results, Context context) {
        this.results = results;
        this.context = context;
    }

    @Override
    public void onBindViewHolder(ResultListAdapter.MyViewHolder holder, int position) {
        holder.name.setText(results.get(position).getArtistName());
        holder.collectionName.setText(results.get(position).getCollectionName());


    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView collectionName;
//        ImageView artworkURL;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            collectionName=(TextView) itemView.findViewById(R.id.collectionname);
//            image =(ImageView) itemView.findViewById(R.id.image);
        }
    }
    @Override
    public int getItemCount() {
        return results.size();
    }

}
