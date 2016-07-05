package com.nilportugues.simplewebapi.main;


import com.nilportugues.simplewebapi.main.domain.usecase.FindUser;
import com.nilportugues.simplewebapi.main.domain.usecase.ListUsers;
import com.nilportugues.simplewebapi.main.repository.user.UserRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
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
    UserRepository provideContactRepository() {
        return new UserRepository();
    }

}
