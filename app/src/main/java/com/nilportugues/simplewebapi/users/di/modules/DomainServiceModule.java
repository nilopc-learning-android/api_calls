package com.nilportugues.simplewebapi.users.di.modules;

import com.nilportugues.simplewebapi.main.di.PerActivity;
import com.nilportugues.simplewebapi.users.domain.services.GetUserByEmail;
import com.nilportugues.simplewebapi.users.repository.UserRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class DomainServiceModule {
    @Provides
    @PerActivity
    GetUserByEmail providesUserDataQuery(UserRepository userRepository) {
        return new GetUserByEmail(userRepository);
    }
}
