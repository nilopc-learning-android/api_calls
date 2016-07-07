package com.nilportugues.simplewebapi.users.di.modules;

import com.nilportugues.simplewebapi.users.domain.services.FindUserQuery;
import com.nilportugues.simplewebapi.users.domain.services.ListUsers;
import com.nilportugues.simplewebapi.users.repository.UserRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UseCaseModule {


    @Provides
    @Singleton
    FindUserQuery providesFindUser(UserRepository userRepository) {
        return new FindUserQuery(userRepository);
    }

    @Provides
    @Singleton
    ListUsers providesListUser(UserRepository userRepository) {
        return new ListUsers(userRepository);
    }
}
