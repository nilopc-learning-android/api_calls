package com.nilportugues.simplewebapi.repository;

import android.util.Log;

import com.nilportugues.simplewebapi.domain.model.User;
import com.nilportugues.simplewebapi.domain.model.attributes.Email;
import com.nilportugues.simplewebapi.network.UserApi;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ContactRepository {

    static final String API_URL = "http://jsonplaceholder.typicode.com/";

    private UserApi api;

    public ContactRepository()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(UserApi.class);
    }

    public User findByEmail(Email email)
    {
        Call<List<User>> call = api.findByEmail(email.getEmail());
        User user = new User();

        try {
            List<User> userList = call.execute().body();
            if (!userList.isEmpty()) {
                user = userList.get(0);
            }
        } catch (IOException e) {
            Log.e("URL", call.request().url().toString());
        }

        return user;
    }
}
