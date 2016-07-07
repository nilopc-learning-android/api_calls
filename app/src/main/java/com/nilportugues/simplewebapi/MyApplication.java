package com.nilportugues.simplewebapi;

import android.app.Application;



public class MyApplication extends Application {
    private MainComponent mMainComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mMainComponent = DaggerMainComponent
                .builder()
                .mainModule(new MainModule(this))
                .build();
    }

    public MainComponent getApplicationComponent()
    {
        return this.mMainComponent;
    }
}
