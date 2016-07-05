package com.nilportugues.simplewebapi.main;

import com.nilportugues.simplewebapi.main.ui.activities.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
    modules = {
        MainModule.class
    }
)
public interface MainComponent {
    void inject(MainActivity activity);
}
