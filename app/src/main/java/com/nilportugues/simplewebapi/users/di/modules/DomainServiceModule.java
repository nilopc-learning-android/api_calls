package com.nilportugues.simplewebapi.users.di.modules;

import com.nilportugues.simplewebapi.users.domain.services.GetUserService;
import com.nilportugues.simplewebapi.users.domain.services.GetUsersService;
import com.nilportugues.simplewebapi.users.repository.UserRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DomainServiceModule {
    @Provides
    @Singleton
    GetUserService providesGetUserService(UserRepository userRepository) {
        return new GetUserService(userRepository);
    }

    @Provides
    @Singleton
    GetUsersService providesGetUsersService(UserRepository userRepository) {
        return new GetUsersService(userRepository);
    }
}
