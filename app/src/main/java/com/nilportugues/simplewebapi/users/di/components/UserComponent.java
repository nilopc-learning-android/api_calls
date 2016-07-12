package com.nilportugues.simplewebapi.users.di.components;

import com.nilportugues.simplewebapi.users.di.modules.ApiModule;
import com.nilportugues.simplewebapi.users.di.modules.DomainServiceModule;
import com.nilportugues.simplewebapi.users.di.modules.RepositoryModule;
import com.nilportugues.simplewebapi.users.ui.activities.Activity2;
import com.nilportugues.simplewebapi.users.ui.activities.UserSearchActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                ApiModule.class,
                DomainServiceModule.class,
                RepositoryModule.class
        }
)
public interface UserComponent {
    void inject(Activity2 activity);
    void inject(UserSearchActivity activity);
}
