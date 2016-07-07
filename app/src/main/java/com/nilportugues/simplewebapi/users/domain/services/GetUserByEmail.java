package com.nilportugues.simplewebapi.users.domain.services;

import com.nilportugues.simplewebapi.users.domain.model.attributes.Email;
import com.nilportugues.simplewebapi.users.repository.UserRepository;
import com.nilportugues.simplewebapi.users.repository.model.User;

import rx.Observable;

public class GetUserByEmail {

    UserRepository userRepository;

    public GetUserByEmail(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Observable<User> execute(final Email email)
    {
        return userRepository.findByEmail(email);
    }
}
