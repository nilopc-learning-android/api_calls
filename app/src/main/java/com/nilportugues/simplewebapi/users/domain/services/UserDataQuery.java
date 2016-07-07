package com.nilportugues.simplewebapi.users.domain.services;

import com.nilportugues.simplewebapi.users.domain.model.attributes.UserId;
import com.nilportugues.simplewebapi.users.repository.UserRepository;
import com.nilportugues.simplewebapi.users.repository.model.User;

import rx.Observable;

public class UserDataQuery {

    private UserRepository userRepository;

    public UserDataQuery(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Observable<User> byUserId(UserId userId) {
        return userRepository.findById(userId);
    }
}
