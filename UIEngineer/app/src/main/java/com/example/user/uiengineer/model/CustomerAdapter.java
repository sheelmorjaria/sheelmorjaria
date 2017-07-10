package com.example.user.uiengineer.model;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.uiengineer.R;

import java.util.ArrayList;



/**
 * Created by user on 7/7/2017.
 */

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.MyViewHolder> {
    ArrayList<CustomerModel> customerModelList;
    public CustomerAdapter(ArrayList<CustomerModel> customerModelList) {
        this.customerModelList = customerModelList;
    }

    @Override
    public int getItemCount() {
        return customerModelList.size();
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.customer_row , parent, false);
        return new MyViewHolder(v);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtViewName;
        TextView txtViewAge;

        public MyViewHolder(View itemView) {
            super(itemView);
            txtViewName = (TextView) itemView.findViewById(R.id.txtViewName);
            txtViewAge = (TextView) itemView.findViewById(R.id.txtViewAge);
        }
    }
    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int position) {
        viewHolder.txtViewName.setText(customerModelList.get(position).getNameSave());
        viewHolder.txtViewAge.setText(customerModelList.get(position).getAgeSave());

    }
}

