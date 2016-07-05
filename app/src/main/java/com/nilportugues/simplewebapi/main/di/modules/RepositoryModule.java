package com.nilportugues.simplewebapi.main.di.modules;

import com.nilportugues.simplewebapi.main.repository.user.UserRepository;
import com.nilportugues.simplewebapi.main.repository.user.api.UserApiFactory;

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
