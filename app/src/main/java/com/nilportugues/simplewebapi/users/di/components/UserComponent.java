package com.nilportugues.simplewebapi.users.di.components;

import com.nilportugues.simplewebapi.MainComponent;
import com.nilportugues.simplewebapi.main.di.PerActivity;
import com.nilportugues.simplewebapi.users.di.modules.ApiModule;
import com.nilportugues.simplewebapi.users.di.modules.DomainServiceModule;
import com.nilportugues.simplewebapi.users.di.modules.RepositoryModule;
import com.nilportugues.simplewebapi.users.ui.activities.BaseActivity;

import dagger.Component;

@PerActivity
@Component(
        dependencies = MainComponent.class,
        modules = {
                ApiModule.class,
                DomainServiceModule.class,
                RepositoryModule.class
        }
)
public interface UserComponent {
    void inject(BaseActivity activity);
}
