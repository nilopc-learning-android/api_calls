
package com.nilportugues.simplewebapi.domain.model.attributes;

public class Geo {

    String lat;
    String lng;

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
