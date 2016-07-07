package com.nilportugues.simplewebapi.users.di.modules;

import com.nilportugues.simplewebapi.users.domain.services.UserDataQuery;
import com.nilportugues.simplewebapi.users.interactors.SearchUser;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class InteractorsModule {

    @Provides
    @Singleton
    SearchUser providesSearchUser(UserDataQuery userDataQuery) {
        return new SearchUser(userDataQuery);
    }
}
