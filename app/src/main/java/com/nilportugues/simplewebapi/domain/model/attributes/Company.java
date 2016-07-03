
package com.nilportugues.simplewebapi.domain.model.attributes;

import java.util.HashMap;
import java.util.Map;

public class Company {

    private String name;
    private String catchPhrase;
    private String bs;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getName() {
        return name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }
}
