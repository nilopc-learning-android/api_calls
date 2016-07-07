package com.nilportugues.simplewebapi.main.executors;

import com.nilportugues.simplewebapi.main.threads.PostExecutionThread;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;


public class UIThread implements PostExecutionThread
{
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}