package com.nilportugues.simplewebapi.domain.model;

import com.nilportugues.simplewebapi.domain.model.attributes.Address;
import com.nilportugues.simplewebapi.domain.model.attributes.Company;
import com.nilportugues.simplewebapi.domain.model.attributes.UserId;

import java.util.HashMap;
import java.util.Map;


public class User {

    private final UserId id;
    private final String name;
    private final String username;
    private final String email;
    private final Address address;
    private final String phone;
    private final String website;
    private final Company company;
    private Map<String, Object> additionalProperties = new HashMap<>();

    public User(UserId id,
                String name,
                String username,
                String email,
                Address address,
                String phone,
                String website,
                Company company,
                Map<String, Object> additionalProperties
    ) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.company = company;
        this.additionalProperties = additionalProperties;
    }

    public UserId getId() {
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


    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }
}
