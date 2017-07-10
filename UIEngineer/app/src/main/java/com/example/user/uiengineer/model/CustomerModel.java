package com.example.user.uiengineer.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Arrays;

import io.realm.RealmObject;
import io.realm.annotations.Required;

/**
 * Created by user on 7/9/2017.
 */

public class CustomerModel extends RealmObject implements Parcelable {

    String nameSave;

    String ageSave;

    String countryNameSave;
    String genderSave;

    String addressSave;
    String pathtoPhoto;


    protected CustomerModel(Parcel in) {
        nameSave = in.readString();
        ageSave = in.readString();
        countryNameSave = in.readString();
        genderSave = in.readString();
        addressSave = in.readString();
        pathtoPhoto = in.readString();
    }

    public static final Creator<CustomerModel> CREATOR = new Creator<CustomerModel>() {
        @Override
        public CustomerModel createFromParcel(Parcel in) {
            return new CustomerModel(in);
        }

        @Override
        public CustomerModel[] newArray(int size) {
            return new CustomerModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(nameSave);
        out.writeString(ageSave);
        out.writeString(countryNameSave);
        out.writeString(genderSave);
        out.writeString(addressSave);
        out.writeString(pathtoPhoto);
    }

    public CustomerModel(){

    }

    @Override
    public String toString() {
        return "CustomerModel{" +
                "nameSave='" + nameSave + '\'' +
                ", ageSave='" + ageSave + '\'' +
                ", countryNameSave='" + countryNameSave + '\'' +
                ", genderSave='" + genderSave + '\'' +
                ", addressSave='" + addressSave + '\'' +
                ", pathtoPhoto='" + pathtoPhoto + '\'' +
                '}';
    }


    public String getPathtoPhoto() {
        return pathtoPhoto;
    }

    public void setPathtoPhoto(String pathtoPhoto) {
        this.pathtoPhoto = pathtoPhoto;
    }

    public String getNameSave() {
        return nameSave;
    }

    public void setNameSave(String nameSave) {
        this.nameSave = nameSave;
    }

    public String getAgeSave() {
        return ageSave;
    }

    public void setAgeSave(String ageSave) {
        this.ageSave = ageSave;
    }

    public String getCountryNameSave() {
        return countryNameSave;
    }

    public void setCountryNameSave(String countryNameSave) {
        this.countryNameSave = countryNameSave;
    }

    public String getGenderSave() {
        return genderSave;
    }

    public void setGenderSave(String genderSave) {
        this.genderSave = genderSave;
    }

    public String getAddressSave() {
        return addressSave;
    }

    public void setAddressSave(String addressSave) {
        this.addressSave = addressSave;
    }
}
