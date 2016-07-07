package com.nilportugues.simplewebapi.users.di.modules;

import com.nilportugues.simplewebapi.users.domain.services.UserDataQuery;
import com.nilportugues.simplewebapi.users.repository.UserRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DomainServiceModule {
    @Provides
    @Singleton
    UserDataQuery providesUserDataQuery(UserRepository userRepository) {
        return new UserDataQuery(userRepository);
    }
}
