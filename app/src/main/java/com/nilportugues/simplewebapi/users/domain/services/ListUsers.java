package com.nilportugues.simplewebapi.users.domain.services;

import com.nilportugues.simplewebapi.users.repository.UserRepository;

public class ListUsers {
    private UserRepository userRepository;

    public ListUsers(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}
