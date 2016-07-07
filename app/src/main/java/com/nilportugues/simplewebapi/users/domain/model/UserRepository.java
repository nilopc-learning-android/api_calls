package com.nilportugues.simplewebapi.users.domain.model;

import com.nilportugues.simplewebapi.users.domain.model.attributes.UserId;
import com.nilportugues.simplewebapi.users.repository.model.User;

import rx.Observable;

public interface UserRepository {
    Observable<User> findById(UserId userId);
}
