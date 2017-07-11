package com.example.user.uiengineer.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.uiengineer.R;

import java.util.ArrayList;


/**
 * Created by user on 7/7/2017.
 */

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.MyViewHolder> {
    ArrayList<CustomerModel> customerModelList;
    byte[] photoByteArray;
    Bitmap bmpPhoto;

    public CustomerAdapter(ArrayList<CustomerModel> customerModelList) {
        this.customerModelList = customerModelList;
    }

    @Override
    public int getItemCount() {
        return customerModelList.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.customer_row2, parent, false);
        return new MyViewHolder(v);
    }

   public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        TextView textViewAge;
        TextView textViewCountry;
        TextView textViewGender;
        TextView textViewAddress;
       ImageView imageViewPhoto;

        public MyViewHolder(View itemView) {
            super(itemView);
            textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            textViewAge = (TextView) itemView.findViewById(R.id.textViewAge);
            textViewCountry = (TextView) itemView.findViewById(R.id.textViewCountry);
            textViewGender = (TextView) itemView.findViewById(R.id.textViewGender);
            textViewAddress = (TextView) itemView.findViewById(R.id.textViewAddress);
            imageViewPhoto = (ImageView) itemView.findViewById(R.id.imageViewPhoto);
        }
    }
    public Bitmap getBitmap(byte[] bitmap) {
        return BitmapFactory.decodeByteArray(bitmap , 0, bitmap.length);
    }
    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int position) {
        viewHolder.textViewName.setText(customerModelList.get(position).getNameSave());
       viewHolder.textViewAge.setText(customerModelList.get(position).getAgeSave());
        viewHolder.textViewCountry.setText(customerModelList.get(position).getCountryNameSave());
        viewHolder.textViewGender.setText(customerModelList.get(position).getGenderSave());
        viewHolder.textViewAddress.setText(customerModelList.get(position).getAddressSave());
        photoByteArray=customerModelList.get(position).getPhotoByteArray();
        try{
            bmpPhoto= getBitmap(photoByteArray);
            viewHolder.imageViewPhoto.setImageBitmap(bmpPhoto);
        }catch (Exception exception)
        {
            exception.printStackTrace();
        }

    }

}

