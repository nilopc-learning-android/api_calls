package com.nilportugues.simplewebapi.users.domain.services;

import com.nilportugues.simplewebapi.users.repository.UserRepository;
import com.nilportugues.simplewebapi.users.repository.model.User;

import java.util.List;

import rx.Observable;

public class GetUsersService {

    private UserRepository userRepository;

    public GetUsersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Observable<List<User>> execute() {
        return userRepository.findAll();
    }

}
