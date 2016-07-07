package com.nilportugues.simplewebapi.main.executors;

import rx.Scheduler;


public interface BackgroundThread {
    Scheduler getScheduler();
}
