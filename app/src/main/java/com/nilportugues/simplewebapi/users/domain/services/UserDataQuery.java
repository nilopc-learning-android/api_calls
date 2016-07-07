package com.nilportugues.simplewebapi.users.domain.services;

import com.nilportugues.simplewebapi.users.domain.model.attributes.Email;
import com.nilportugues.simplewebapi.users.repository.UserRepository;
import com.nilportugues.simplewebapi.users.repository.model.User;

public class UserDataQuery {

    private UserRepository userRepository;

    public UserDataQuery(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User byEmail(Email email) {
        return userRepository.findByEmail(email);
    }
}
