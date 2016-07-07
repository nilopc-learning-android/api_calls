package com.nilportugues.simplewebapi.shared.executors;

import com.nilportugues.simplewebapi.shared.threads.BackgroundThread;

import rx.Scheduler;
import rx.schedulers.Schedulers;

public class ComputationalThread implements BackgroundThread {

    @Override
    public Scheduler getScheduler() {
        return Schedulers.computation();
    }
}