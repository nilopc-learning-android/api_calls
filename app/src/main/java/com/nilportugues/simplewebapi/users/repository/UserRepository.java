package com.nilportugues.simplewebapi.users.repository;

import com.nilportugues.simplewebapi.users.domain.model.attributes.UserId;
import com.nilportugues.simplewebapi.users.network.UserApi;
import com.nilportugues.simplewebapi.users.network.UserApiFactory;
import com.nilportugues.simplewebapi.users.repository.model.User;

import rx.Observable;

public class UserRepository implements com.nilportugues.simplewebapi.users.domain.model.UserRepository{

    UserApi apiClient;

    public UserRepository(UserApiFactory apiClient) {
        this.apiClient = apiClient.create();
    }

    public Observable<User> findById(UserId userId) {
        return apiClient.findUser(userId.getUserId());
    }
}
