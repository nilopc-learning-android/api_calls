package com.nilportugues.simplewebapi.main.domain.usecase;

import com.nilportugues.simplewebapi.main.repository.user.UserRepository;
import com.nilportugues.simplewebapi.main.repository.user.model.User;

import java.util.List;

public class ListUsers {
    private UserRepository userRepository;

    public ListUsers(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> list() {
        return userRepository.findAll();
    }
}
