package com.nilportugues.simplewebapi.main.domain.usecase;

import com.nilportugues.simplewebapi.main.domain.model.attributes.Email;
import com.nilportugues.simplewebapi.main.repository.user.UserRepository;
import com.nilportugues.simplewebapi.main.repository.user.model.User;

public class FindUser {

    private UserRepository userRepository;

    public FindUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User byEmail(Email email) {
        return userRepository.findByEmail(email);
    }
}
