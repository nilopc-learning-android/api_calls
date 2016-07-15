package com.nilportugues.simplewebapi.users.di.modules;

import com.nilportugues.simplewebapi.users.domain.services.GetUsersService;
import com.nilportugues.simplewebapi.users.interactors.ListUsers;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationServiceModule {
    @Provides
    @Singleton
    ListUsers providesListUsers(GetUsersService getUsersService) {
        return new ListUsers(getUsersService);
    }
}
