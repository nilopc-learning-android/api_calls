package com.nilportugues.simplewebapi.users.domain.model;

import com.nilportugues.simplewebapi.users.domain.model.attributes.UserId;


public class User {
    private final UserId userId;
    private final String email;
    private final String username;

    public User(UserId userId, String email, String username) {
        this.userId = userId;
        this.email = email;
        this.username = username;
    }

    public UserId getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }
}
