package com.nilportugues.simplewebapi;

import android.content.Context;

import com.nilportugues.simplewebapi.shared.executor.PostExecutionThread;
import com.nilportugues.simplewebapi.shared.executor.ThreadExecutor;
import com.nilportugues.simplewebapi.shared.ui.activities.SharedBaseActivity;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = MainModule.class)
public interface MainComponent {
    void inject(SharedBaseActivity activity);

    Context context();
    ThreadExecutor threadExecutor();
    PostExecutionThread postExecutionThread();
}
