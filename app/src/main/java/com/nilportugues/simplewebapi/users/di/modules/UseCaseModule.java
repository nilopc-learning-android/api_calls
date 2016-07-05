package com.nilportugues.simplewebapi.users.di.modules;

import com.nilportugues.simplewebapi.users.domain.usecase.FindUser;
import com.nilportugues.simplewebapi.users.domain.usecase.ListUsers;
import com.nilportugues.simplewebapi.users.repository.UserRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UseCaseModule {


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
}
