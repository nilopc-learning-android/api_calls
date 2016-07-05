package com.nilportugues.simplewebapi.users.di.components;

import com.nilportugues.simplewebapi.users.ui.activities.UserSearchActivity;
import com.nilportugues.simplewebapi.users.di.modules.ApiModule;
import com.nilportugues.simplewebapi.users.di.modules.RepositoryModule;
import com.nilportugues.simplewebapi.users.di.modules.UseCaseModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                ApiModule.class,
                UseCaseModule.class,
                RepositoryModule.class
        }
)
public interface UserComponent {
    void inject(UserSearchActivity activity);
}
