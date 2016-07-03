
package com.nilportugues.simplewebapi.domain.model;

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

    /**
     * No args constructor for use in serialization
     */
    public Company() {
    }

    /**
     * @param catchPhrase
     * @param name
     * @param bs
     */
    public Company(String name, String catchPhrase, String bs) {
        this.name = name;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The catchPhrase
     */
    public String getCatchPhrase() {
        return catchPhrase;
    }

    /**
     * @param catchPhrase The catchPhrase
     */
    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    /**
     * @return The bs
     */
    public String getBs() {
        return bs;
    }

    /**
     * @param bs The bs
     */
    public void setBs(String bs) {
        this.bs = bs;
    }

}
