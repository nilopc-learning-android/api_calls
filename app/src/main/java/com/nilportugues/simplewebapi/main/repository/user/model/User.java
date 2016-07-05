package com.nilportugues.simplewebapi.main.repository.user.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class User {

    @SerializedName("id")
    @Expose
    Integer id;

    @SerializedName("name")
    @Expose
    String name;

    @SerializedName("username")
    @Expose
    String username;

    @SerializedName("email")
    @Expose
    String email;

    @SerializedName("address")
    @Expose
    Address address;

    @SerializedName("phone")
    @Expose
    String phone;

    @SerializedName("website")
    @Expose
    String website;

    @SerializedName("company")
    @Expose
    Company company;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public Company getCompany() {
        return company;
    }
}
