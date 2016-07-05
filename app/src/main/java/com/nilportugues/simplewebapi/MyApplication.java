package com.nilportugues.simplewebapi;

import android.app.Application;

import com.nilportugues.simplewebapi.main.di.components.DaggerMainComponent;
import com.nilportugues.simplewebapi.main.di.components.MainComponent;
import com.nilportugues.simplewebapi.main.di.modules.MainModule;


public class MyApplication extends Application
{
    private MainComponent mMainComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mMainComponent = DaggerMainComponent
                .builder()
                .mainModule(new MainModule(this))
                .build();
    }

    public MainComponent getMainComponent() {
        return mMainComponent;
    }
}
