package com.nilportugues.simplewebapi.users.domain.usecase;

import com.nilportugues.simplewebapi.users.domain.model.attributes.Email;
import com.nilportugues.simplewebapi.users.repository.UserRepository;
import com.nilportugues.simplewebapi.users.repository.model.User;

public class FindUser {

    private UserRepository userRepository;

    public FindUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User byEmail(Email email) {
        return userRepository.findByEmail(email);
    }
}
