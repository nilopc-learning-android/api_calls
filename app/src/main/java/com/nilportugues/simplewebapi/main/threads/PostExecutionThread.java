package com.nilportugues.simplewebapi.main.threads;

import rx.Scheduler;


public interface PostExecutionThread {
    Scheduler getScheduler();
}
