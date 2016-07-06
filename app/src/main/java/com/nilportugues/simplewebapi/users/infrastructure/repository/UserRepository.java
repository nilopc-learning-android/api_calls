package com.nilportugues.simplewebapi.users.infrastructure.repository;

import android.util.Log;

import com.nilportugues.simplewebapi.users.domain.model.attributes.Email;
import com.nilportugues.simplewebapi.users.infrastructure.api.UserApi;
import com.nilportugues.simplewebapi.users.infrastructure.api.UserApiFactory;
import com.nilportugues.simplewebapi.users.infrastructure.repository.model.User;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;

public class UserRepository implements com.nilportugues.simplewebapi.users.domain.model.UserRepository{

    UserApi apiClient;

    public UserRepository(UserApiFactory apiClient) {
        this.apiClient = apiClient.create();
    }

    public User findByEmail(Email email) {
        Call<List<User>> call = apiClient.findByEmail(email.getEmail());
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
