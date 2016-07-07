package com.nilportugues.simplewebapi.main.executors;

import rx.Scheduler;
import rx.schedulers.Schedulers;

public class ComputationalThread implements BackgroundThread {

    @Override
    public Scheduler getScheduler() {
        return Schedulers.computation();
    }
}