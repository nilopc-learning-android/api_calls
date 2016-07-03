package com.nilportugues.simplewebapi.domain.model.attributes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserId {

    @SerializedName("lat")
    @Expose
    String id;

    public UserId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String toString() {
        return id;
    }
}
