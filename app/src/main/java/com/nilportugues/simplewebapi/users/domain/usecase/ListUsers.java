package com.nilportugues.simplewebapi.users.domain.usecase;

import com.nilportugues.simplewebapi.users.repository.UserRepository;
import com.nilportugues.simplewebapi.users.repository.model.User;

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
