package com.nilportugues.simplewebapi.main.repository.datasource.userapi.transformers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Address {

    @SerializedName("street")
    @Expose
    String street;

    @SerializedName("suite")
    @Expose
    String suite;

    @SerializedName("city")
    @Expose
    String city;

    @SerializedName("zipcode")
    @Expose
    String zipcode;

    @SerializedName("geo")
    @Expose
    Geo geo;

    public Address() {
    }

    public Address(String street, String suite, String city, String zipcode, Geo geo) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.geo = geo;
    }

    public String getStreet() {
        return street;
    }

    public String getSuite() {
        return suite;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public Geo getGeo() {
        return geo;
    }
}
