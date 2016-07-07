package com.nilportugues.simplewebapi.users.domain.model.attributes;

public class UserId {

    private final String userId;

    public UserId() {
        this.userId = "";
    }

    public UserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;

    }

    public String toString() {
        return userId;
    }
}
