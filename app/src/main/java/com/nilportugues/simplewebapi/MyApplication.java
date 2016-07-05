package com.nilportugues.simplewebapi;

import android.app.Application;

import com.nilportugues.simplewebapi.main.di.components.DaggerMainComponent;
import com.nilportugues.simplewebapi.main.di.components.MainComponent;
import com.nilportugues.simplewebapi.users.di.components.DaggerUserComponent;
import com.nilportugues.simplewebapi.users.di.components.UserComponent;


public class MyApplication extends Application {
    private MainComponent mMainComponent;
    private UserComponent mUserComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mMainComponent = DaggerMainComponent.builder().build();
        mUserComponent = DaggerUserComponent.builder().build();
    }

    public MainComponent getMainComponent() {
        return mMainComponent;
    }

    public UserComponent getUserComponent() {
        return mUserComponent;
    }
}
