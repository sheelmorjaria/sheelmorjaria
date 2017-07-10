package com.example.user.uiengineer.model;

import java.util.ArrayList;
import java.util.Arrays;

import io.realm.RealmObject;
import io.realm.annotations.Required;

/**
 * Created by user on 7/9/2017.
 */

public class CustomerModel extends RealmObject {
    @Required
    String nameSave;
    @Required
    String ageSave;
    @Required
    String countryNameSave;
    @Required
    String genderSave;
    @Required
    String addressSave;
    String pathtoPhoto;

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

    public CustomerModel(String nameSave, String ageSave, String countryNameSave, String genderSave, String addressSave, String pathtoPhoto) {
        this.nameSave = nameSave;
        this.ageSave = ageSave;
        this.countryNameSave = countryNameSave;
        this.genderSave = genderSave;
        this.addressSave = addressSave;
        this.pathtoPhoto = pathtoPhoto;
    }
    public CustomerModel(String nameSave, String ageSave, String countryNameSave, String genderSave, String addressSave ) {
        this.nameSave = nameSave;
        this.ageSave = ageSave;
        this.countryNameSave = countryNameSave;
        this.genderSave = genderSave;
        this.addressSave = addressSave;
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
