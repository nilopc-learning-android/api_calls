
package com.nilportugues.simplewebapi.domain.model.attributes;

import java.util.HashMap;
import java.util.Map;

public class Address {

    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }
}
