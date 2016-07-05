package com.nilportugues.simplewebapi.main.repository.user.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Geo {

    @SerializedName("lat")
    @Expose
    String lat;

    @SerializedName("lng")
    @Expose
    String lng;

    public Geo() {
    }

    public Geo(String lat, String lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }
}
