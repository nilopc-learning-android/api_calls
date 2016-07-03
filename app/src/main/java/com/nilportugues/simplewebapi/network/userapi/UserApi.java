package com.nilportugues.simplewebapi.network.userapi;


import com.nilportugues.simplewebapi.network.userapi.transformers.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface UserApi {

    String API_URL = "http://jsonplaceholder.typicode.com/";

    @GET("users")
    Call<List<User>> getUsers();

    @GET("users")
    Call<List<User>> findByEmail(@Query("email") String email);
}
