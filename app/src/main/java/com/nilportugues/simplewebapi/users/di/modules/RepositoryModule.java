package com.nilportugues.simplewebapi.users.di.modules;

import com.nilportugues.simplewebapi.main.di.PerActivity;
import com.nilportugues.simplewebapi.users.network.UserApiFactory;
import com.nilportugues.simplewebapi.users.repository.UserRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    @PerActivity
    UserRepository provideUserRepository(UserApiFactory apiFactory) {
        return new UserRepository(apiFactory);
    }
}
