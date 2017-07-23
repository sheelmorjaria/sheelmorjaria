package com.example.user.parkingspaces.model;

/**
 * Created by user on 7/21/2017.
 */


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ParkingSpaces implements Parcelable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("lat")
    @Expose
    private String lat;
    @SerializedName("lng")
    @Expose
    private String lng;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("cost_per_minute")
    @Expose
    private String costPerMinute;
    @SerializedName("max_reserve_time_mins")
    @Expose
    private Integer maxReserveTimeMins;
    @SerializedName("min_reserve_time_mins")
    @Expose
    private Integer minReserveTimeMins;
    @SerializedName("is_reserved")
    @Expose
    private Boolean isReserved;
    @SerializedName("reserved_until")
    @Expose
    private String reservedUntil;
    public final static Parcelable.Creator<ParkingSpaces> CREATOR = new Creator<ParkingSpaces>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ParkingSpaces createFromParcel(Parcel in) {
            ParkingSpaces instance = new ParkingSpaces();
            instance.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.lat = ((String) in.readValue((String.class.getClassLoader())));
            instance.lng = ((String) in.readValue((String.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.costPerMinute = ((String) in.readValue((String.class.getClassLoader())));
            instance.maxReserveTimeMins = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.minReserveTimeMins = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.isReserved = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.reservedUntil = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public ParkingSpaces[] newArray(int size) {
            return (new ParkingSpaces[size]);
        }

    }
            ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCostPerMinute() {
        return costPerMinute;
    }

    public void setCostPerMinute(String costPerMinute) {
        this.costPerMinute = costPerMinute;
    }

    public Integer getMaxReserveTimeMins() {
        return maxReserveTimeMins;
    }

    public void setMaxReserveTimeMins(Integer maxReserveTimeMins) {
        this.maxReserveTimeMins = maxReserveTimeMins;
    }

    public Integer getMinReserveTimeMins() {
        return minReserveTimeMins;
    }

    public void setMinReserveTimeMins(Integer minReserveTimeMins) {
        this.minReserveTimeMins = minReserveTimeMins;
    }

    public Boolean getIsReserved() {
        return isReserved;
    }

    public void setIsReserved(Boolean isReserved) {
        this.isReserved = isReserved;
    }

    public String getReservedUntil() {
        return reservedUntil;
    }

    public void setReservedUntil(String reservedUntil) {
        this.reservedUntil = reservedUntil;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(lat);
        dest.writeValue(lng);
        dest.writeValue(name);
        dest.writeValue(costPerMinute);
        dest.writeValue(maxReserveTimeMins);
        dest.writeValue(minReserveTimeMins);
        dest.writeValue(isReserved);
        dest.writeValue(reservedUntil);
    }

    public int describeContents() {
        return 0;
    }

}
