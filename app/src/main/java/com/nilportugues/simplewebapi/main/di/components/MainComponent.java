package com.nilportugues.simplewebapi.main.di.components;

import com.nilportugues.simplewebapi.main.di.modules.MainModule;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(
        modules = {
                MainModule.class
        }
)
public interface MainComponent {

}
