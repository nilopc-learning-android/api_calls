package com.nilportugues.simplewebapi.users.domain.model.attributes;

public class UserId {

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
