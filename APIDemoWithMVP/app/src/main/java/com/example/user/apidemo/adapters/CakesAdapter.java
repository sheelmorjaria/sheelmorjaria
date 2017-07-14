package com.example.user.apidemo.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.user.apidemo.R;
import com.example.user.apidemo.model.CakeModel;

import java.util.List;

/**
 * Created by user on 7/12/2017.
 */

public class CakesAdapter extends RecyclerView.Adapter<CakesAdapter.MyViewHolder>
{
    List<CakeModel> cakesModelList;
    Context context;
    @Override
    public void onBindViewHolder(CakesAdapter.MyViewHolder holder, int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    public CakesAdapter(List<CakeModel> cakesModelArrayList, Context applicationContext) {
        this.cakesModelList = cakesModelArrayList;
        this.context=applicationContext;
            }
public int getItemCount(){return cakesModelList.size();}

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardviewcake, parent, false);
        return new MyViewHolder(v);
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView description;
        ImageView image;

        public MyViewHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.title);
            description=(TextView) itemView.findViewById(R.id.description);
           image =(ImageView) itemView.findViewById(R.id.image);
        }
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText(cakesModelList.get(position).getTitle());
        holder.description.setText(cakesModelList.get(position).getDesc());
        Log.i("cakesModelList.get(position).getTitle()",cakesModelList.get(position).getTitle() );
    String url = cakesModelList.get(position).getImage();
        Glide
                .with(context)
                .load(url)
                .into(holder.image);

    }
}
