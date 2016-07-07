package com.nilportugues.simplewebapi.shared.executors;

import com.nilportugues.simplewebapi.shared.threads.BackgroundThread;

import rx.Scheduler;
import rx.schedulers.Schedulers;


public class IOThread implements BackgroundThread {
    @Override
    public Scheduler getScheduler() {
        return Schedulers.io();
    }
}
