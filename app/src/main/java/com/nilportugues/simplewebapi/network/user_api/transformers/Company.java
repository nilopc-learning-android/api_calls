
package com.nilportugues.simplewebapi.network.user_api.transformers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Company {

    @SerializedName("name")
    @Expose
    String name;

    @SerializedName("catchPhrase")
    @Expose
    String catchPhrase;

    @SerializedName("bs")
    @Expose
    String bs;

    public Company() {
    }

    public Company(String name, String catchPhrase, String bs) {
        this.name = name;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }

    public String getName() {
        return name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public String getBs() {
        return bs;
    }
}
