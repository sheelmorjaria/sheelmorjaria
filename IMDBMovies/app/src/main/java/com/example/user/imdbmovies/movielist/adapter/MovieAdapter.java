package com.example.user.imdbmovies.movielist.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.imdbmovies.R;
import com.example.user.imdbmovies.movielist.model.Results;

import java.util.List;

/**
 * Created by user on 7/13/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {
    List<Results> result;
    Context context;

    public MovieAdapter() {
        super();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView overview;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
//            overview = (TextView) itemView.findViewById(R.id.overview);
//            ListView listViewMovies = (ListView) itemView.findViewById(R.id.lvResults);

        }
    }
    @Override
    public int getItemCount() {
        return result.size();
    }

    public MovieAdapter(List<Results> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @Override
    public void onBindViewHolder(MovieAdapter.MyViewHolder holder, int position) {


            holder.title.setText(result.get(position).getTitle());


    }



    @Override
    public MovieAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardrow, parent, false);
        return new MyViewHolder(view);
    }
}
