
package com.nilportugues.simplewebapi.domain.model.attributes;

import java.util.HashMap;
import java.util.Map;

public class Geo {

    private String lat;
    private String lng;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }
}
