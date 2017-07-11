package com.example.user.uiengineer.model;

import android.os.Parcel;
import android.os.Parcelable;

import io.realm.RealmObject;

/**
 * Created by user on 7/9/2017.
 */

public class CustomerModel extends RealmObject implements Parcelable {
    byte[] photoByteArray;
    String nameSave;
    String ageSave;
    String countryNameSave;
    String genderSave;
    String addressSave;
    public byte[] getPhotoByteArray() {
        return photoByteArray;
    }
    public void setPhotoByteArray(byte[] photoByteArray) {
        this.photoByteArray = photoByteArray;
    }


    protected CustomerModel(Parcel in) {
        nameSave = in.readString();
        ageSave = in.readString();
        countryNameSave = in.readString();
        genderSave = in.readString();
        addressSave = in.readString();
        photoByteArray = in.createByteArray();
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
        out.writeByteArray(photoByteArray);
    }

    public CustomerModel(){

    }

    public CustomerModel(String nameSave, String ageSave, String countryNameSave, String genderSave, String addressSave, byte[] photoByteArray) {
        this.nameSave = nameSave;
        this.ageSave = ageSave;
        this.countryNameSave = countryNameSave;
        this.genderSave = genderSave;
        this.addressSave = addressSave;
        this.photoByteArray = photoByteArray;
    }

    @Override
    public String toString() {
        return "CustomerModel{" +
                "nameSave='" + nameSave + '\'' +
                ", ageSave='" + ageSave + '\'' +
                ", countryNameSave='" + countryNameSave + '\'' +
                ", genderSave='" + genderSave + '\'' +
                ", addressSave='" + addressSave + '\'' +
           ", photoByteArray='" + photoByteArray + '\'' +
                '}';
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
