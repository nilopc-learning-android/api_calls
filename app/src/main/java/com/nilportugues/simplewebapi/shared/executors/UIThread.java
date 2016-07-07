package com.nilportugues.simplewebapi.shared.executors;

import com.nilportugues.simplewebapi.shared.threads.PostExecutionThread;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;


public class UIThread implements PostExecutionThread
{
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
