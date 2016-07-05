package com.nilportugues.simplewebapi.users.domain.model.attributes;

public class Email {

    private final String email;

    public Email() {
        this.email = "";
    }

    public Email(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;

    }

    public String toString() {
        return email;
    }
}
