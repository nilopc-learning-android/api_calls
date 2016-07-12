package com.nilportugues.simplewebapi;

import android.app.Application;

import com.nilportugues.simplewebapi.main.di.components.DaggerMainComponent;
import com.nilportugues.simplewebapi.main.di.components.MainComponent;
import com.nilportugues.simplewebapi.users.di.components.DaggerUserComponent;
import com.nilportugues.simplewebapi.users.di.components.UserComponent;
import com.nilportugues.simplewebapi.users.di.modules.ApiModule;
import com.nilportugues.simplewebapi.users.di.modules.DomainServiceModule;
import com.nilportugues.simplewebapi.users.di.modules.RepositoryModule;


public class MyApplication extends Application {
    private MainComponent mMainComponent;
    private UserComponent mUserComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mMainComponent = DaggerMainComponent.builder().build();
        mUserComponent = DaggerUserComponent
                .builder()
                .apiModule(new ApiModule())
                .repositoryModule(new RepositoryModule())
                .domainServiceModule(new DomainServiceModule())
                .build();
    }

    public MainComponent getMainComponent() {
        return mMainComponent;
    }

    public UserComponent getUserComponent() {
        return mUserComponent;
    }
}
