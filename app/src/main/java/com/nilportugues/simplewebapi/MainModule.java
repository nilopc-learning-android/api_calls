package com.nilportugues.simplewebapi;

import android.content.Context;

import com.nilportugues.simplewebapi.main.executors.JobExecutor;
import com.nilportugues.simplewebapi.main.schedulers.UIThread;
import com.nilportugues.simplewebapi.shared.executor.PostExecutionThread;
import com.nilportugues.simplewebapi.shared.executor.ThreadExecutor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    private final MyApplication application;

    public MainModule(MyApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Singleton
    @Provides
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Singleton
    @Provides
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }
}
