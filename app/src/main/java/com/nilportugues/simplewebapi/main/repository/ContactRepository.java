package com.nilportugues.simplewebapi.main.repository;

import android.util.Log;

import com.nilportugues.simplewebapi.main.domain.model.attributes.Email;
import com.nilportugues.simplewebapi.main.repository.datasource.userapi.UserApi;
import com.nilportugues.simplewebapi.main.repository.datasource.userapi.UserApiClient;
import com.nilportugues.simplewebapi.main.repository.datasource.userapi.transformers.User;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;

public class ContactRepository {

    private UserApi apiClient;

    public ContactRepository() {
        apiClient = UserApiClient.getInstance();
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
