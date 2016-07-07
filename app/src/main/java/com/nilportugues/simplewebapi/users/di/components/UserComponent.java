package com.nilportugues.simplewebapi.users.di.components;

import com.nilportugues.simplewebapi.users.di.modules.ApiModule;
import com.nilportugues.simplewebapi.users.di.modules.InteractorsModule;
import com.nilportugues.simplewebapi.users.di.modules.RepositoryModule;
import com.nilportugues.simplewebapi.users.di.modules.DomainServiceModule;
import com.nilportugues.simplewebapi.users.ui.activities.UserSearchActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                ApiModule.class,
                InteractorsModule.class,
                DomainServiceModule.class,
                RepositoryModule.class
        }
)
public interface UserComponent {
    void inject(UserSearchActivity activity);
}
