package com.nilportugues.simplewebapi.shared.threads;

import rx.Scheduler;


public interface PostExecutionThread {
    Scheduler getScheduler();
}
