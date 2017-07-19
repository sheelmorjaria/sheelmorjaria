package com.example.user.weekendassignmenttwo.adapters;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.user.weekendassignmenttwo.R;
import com.example.user.weekendassignmenttwo.model.Result;

import java.io.File;
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
        Double trackPrice = results.get(position).getTrackPrice();
        String priceAsString = String.format ("%.2f", trackPrice);
        holder.price.setText("$"+priceAsString);
        String url =results.get(position).getArtworkUrl60();
        Log.i("URLAddress", url);
        Glide
                .with(context)
                .load(url)
                .into(holder.image);

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(android.content.Intent.ACTION_VIEW);

                intent.setDataAndType(Uri.parse(results.get(position).getPreviewUrl()),"audio/*");
                context.startActivity(intent);
            }
        });
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView collectionName;
        TextView price;
        ImageView image;
        View view;
        public MyViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;
            name = (TextView) itemView.findViewById(R.id.name);
            collectionName=(TextView) itemView.findViewById(R.id.collectionname);
            price=(TextView) itemView.findViewById(R.id.price);

            image =(ImageView) itemView.findViewById(R.id.image);

        }
    }
    @Override
    public int getItemCount() {
        return results.size();
    }

}
