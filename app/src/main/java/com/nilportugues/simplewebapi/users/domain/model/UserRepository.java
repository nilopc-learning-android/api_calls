package com.nilportugues.simplewebapi.users.domain.model;

import com.nilportugues.simplewebapi.users.domain.model.attributes.UserId;
import com.nilportugues.simplewebapi.users.repository.model.User;

import java.util.List;

import rx.Observable;

public interface UserRepository {
    Observable<List<User>> findAll();

    Observable<User> findById(UserId userId);
}
