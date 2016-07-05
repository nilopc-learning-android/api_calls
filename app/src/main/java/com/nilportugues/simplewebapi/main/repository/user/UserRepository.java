package com.nilportugues.simplewebapi.main.repository.user;

import android.util.Log;

import com.nilportugues.simplewebapi.main.domain.model.attributes.Email;
import com.nilportugues.simplewebapi.main.repository.user.api.UserApi;
import com.nilportugues.simplewebapi.main.repository.user.api.UserApiClient;
import com.nilportugues.simplewebapi.main.repository.user.model.User;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;

public class UserRepository implements com.nilportugues.simplewebapi.main.domain.model.UserRepository{

    private UserApi apiClient;

    public UserRepository() {
        apiClient =  UserApiClient.getInstance();
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

    public List<User> findAll()
    {
        Call<List<User>> call = apiClient.getUsers();
        List<User> userList = null;

        try {
            userList = call.execute().body();
        } catch (IOException e) {
            Log.e("URL", call.request().url().toString());
        }

        return userList;
    }
}
