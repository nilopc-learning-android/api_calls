package com.nilportugues.simplewebapi.main.di.modules;

import com.nilportugues.simplewebapi.main.repository.user.api.UserApiFactory;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Provides;
import dagger.Module;

@Module
public class ApiModule {

    @Provides
    @Singleton
    UserApiFactory providesUserApiFactory(@Named("UserApiUrl") String baseUrl) {
        return new UserApiFactory(baseUrl);
    }

    @Provides
    @Singleton
    @Named("UserApiUrl")
    String providesUserApiBaseUrl() {
        return "http://jsonplaceholder.typicode.com/";
    }
}
