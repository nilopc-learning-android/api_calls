package com.nilportugues.simplewebapi.users.di.modules;

import com.nilportugues.simplewebapi.users.repository.UserRepository;
import com.nilportugues.simplewebapi.users.repository.api.UserApiFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {


    @Provides
    @Singleton
    UserRepository provideUserRepository(UserApiFactory apiFactory) {
        return new UserRepository(apiFactory);
    }
}