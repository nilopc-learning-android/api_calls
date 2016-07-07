package com.nilportugues.simplewebapi.main.executors;

import rx.Scheduler;
import rx.schedulers.Schedulers;


public class IOThread implements BackgroundThread {
    @Override
    public Scheduler getScheduler() {
        return Schedulers.io();
    }
}
