package com.nilportugues.simplewebapi.users.di.modules;

import com.nilportugues.simplewebapi.main.di.PerActivity;
import com.nilportugues.simplewebapi.users.network.UserApiFactory;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class ApiModule {
    @PerActivity
    @Provides
    UserApiFactory providesUserApiFactory(@Named("UserApiUrl") String baseUrl) {
        return new UserApiFactory(baseUrl);
    }

    @PerActivity
    @Provides
    @Named("UserApiUrl")
    String providesUserApiBaseUrl() {
        return "http://jsonplaceholder.typicode.com/";
    }
}
