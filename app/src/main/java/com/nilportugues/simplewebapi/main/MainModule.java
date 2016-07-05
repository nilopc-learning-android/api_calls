package com.nilportugues.simplewebapi.main;


import android.app.Application;

import com.nilportugues.simplewebapi.main.domain.usecase.FindUser;
import com.nilportugues.simplewebapi.main.domain.usecase.ListUsers;
import com.nilportugues.simplewebapi.main.repository.user.UserRepository;
import com.nilportugues.simplewebapi.main.repository.user.api.UserApiFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    Application mApplication;

    public MainModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    FindUser providesFindUser(UserRepository userRepository) {
        return new FindUser(userRepository);
    }

    @Provides
    @Singleton
    ListUsers providesListUser(UserRepository userRepository) {
        return new ListUsers(userRepository);
    }

    @Provides
    @Singleton
    UserRepository provideUserRepository(UserApiFactory apiFactory) {
        return new UserRepository(apiFactory);
    }

    @Provides
    @Singleton
    UserApiFactory providesUserApiFactory(String baseUrl) {
        return new UserApiFactory(baseUrl);
    }

    @Provides
    @Singleton
    String providesUserApiBaseUrl() {
        return "http://jsonplaceholder.typicode.com/";
    }
}
