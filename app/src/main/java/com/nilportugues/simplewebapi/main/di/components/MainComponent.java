package com.nilportugues.simplewebapi.main.di.components;

import com.nilportugues.simplewebapi.main.di.modules.MainModule;
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
