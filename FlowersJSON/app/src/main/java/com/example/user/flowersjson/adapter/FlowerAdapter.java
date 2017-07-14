package com.example.user.flowersjson.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.user.flowersjson.R;
import com.example.user.flowersjson.model.FlowerModel;

import java.util.List;

/**
 * Created by user on 7/14/2017.
 */

public class FlowerAdapter extends RecyclerView.Adapter<FlowerAdapter.MyViewHolder>{
    List<FlowerModel> flowerModelList;
    Context context;

    public FlowerAdapter(List<FlowerModel> flowerModelList, Context context) {
        this.flowerModelList = flowerModelList;
        this.context = context;
    }

    @Override
    public void onBindViewHolder(FlowerAdapter.MyViewHolder holder, int position) {
        holder.name.setText(flowerModelList.get(position).getName());
        holder.category.setText(flowerModelList.get(position).getCategory());
        Log.i("title", flowerModelList.get(position).getName());
        holder.instructions.setText(flowerModelList.get(position).getInstructions());
        String url = "http://services.hanselandpetal.com/photos/" + flowerModelList.get(position).getPhoto();
        Log.i("URLAddress", url);
        Glide
                .with(context)
                .load(url)
                .into(holder.photo);


    }

    @Override
    public FlowerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cardviewflowers,parent,false));
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView category;
        TextView instructions;
        TextView price;
        ImageView photo;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            category=(TextView) itemView.findViewById(R.id.category);
            photo =(ImageView) itemView.findViewById(R.id.photo);
            instructions =(TextView) itemView.findViewById(R.id.instructions);
            price = (TextView) itemView.findViewById(R.id.price);
        }
    }
    @Override
    public int getItemCount() {
        return flowerModelList.size();
    }
}
