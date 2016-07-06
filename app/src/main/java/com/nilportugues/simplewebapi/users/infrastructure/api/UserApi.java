package com.nilportugues.simplewebapi.users.infrastructure.api;


import com.nilportugues.simplewebapi.users.infrastructure.repository.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


public interface UserApi {

    @GET("users")
    Observable<List<User>> getUsers();

    @GET("users")
    Call<List<User>> findByEmail(@Query("email") String email);
}
