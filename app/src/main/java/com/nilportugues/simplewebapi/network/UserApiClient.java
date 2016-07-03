package com.nilportugues.simplewebapi.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserApiClient {

    private static UserApi instance;

    private UserApiClient(){}

    public static UserApi getInstance(){
        if (instance == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(UserApi.API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            instance = retrofit.create(UserApi.class);
        }
        return instance;
    }
}