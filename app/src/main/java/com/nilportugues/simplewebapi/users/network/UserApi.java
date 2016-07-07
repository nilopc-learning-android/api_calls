package com.nilportugues.simplewebapi.users.network;


import com.nilportugues.simplewebapi.users.repository.model.User;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;


public interface UserApi {

    @GET("users")
    Observable<List<User>> getUsers();

    @GET("users/{id}")
    Observable<User> findUser(@Path("id") String id);
}
