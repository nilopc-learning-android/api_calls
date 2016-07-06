package com.nilportugues.simplewebapi.users.domain.services;

import com.nilportugues.simplewebapi.users.domain.model.attributes.Email;
import com.nilportugues.simplewebapi.users.infrastructure.repository.UserRepository;
import com.nilportugues.simplewebapi.users.infrastructure.repository.model.User;

public class FindUser {

    private UserRepository userRepository;

    public FindUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User byEmail(Email email) {
        return userRepository.findByEmail(email);
    }
}
