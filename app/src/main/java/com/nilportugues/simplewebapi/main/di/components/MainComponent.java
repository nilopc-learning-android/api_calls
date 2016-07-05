package com.nilportugues.simplewebapi.main.di.components;

import com.nilportugues.simplewebapi.main.di.modules.ApiModule;
import com.nilportugues.simplewebapi.main.di.modules.RepositoryModule;
import com.nilportugues.simplewebapi.main.di.modules.UseCaseModule;
import com.nilportugues.simplewebapi.main.ui.activities.MainActivity;

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
public interface MainComponent {
    void inject(MainActivity activity);
}
