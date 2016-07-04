package com.nilportugues.simplewebapi.main;


import com.nilportugues.simplewebapi.main.domain.usecase.FindUser;
import com.nilportugues.simplewebapi.main.domain.usecase.ListUsers;
import com.nilportugues.simplewebapi.main.repository.ContactRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    @Provides
    @Singleton
    FindUser providesFindUser(ContactRepository contactRepository) {
        return new FindUser(contactRepository);
    }

    @Provides
    @Singleton
    ListUsers providesListUser(ContactRepository contactRepository) {
        return new ListUsers(contactRepository);
    }

    @Provides
    @Singleton
    ContactRepository provideContactRepository() {
        return new ContactRepository();
    }

}
