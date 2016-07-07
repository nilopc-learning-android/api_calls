package com.nilportugues.simplewebapi.main.interactors;

import com.nilportugues.simplewebapi.main.threads.BackgroundThread;
import com.nilportugues.simplewebapi.main.threads.PostExecutionThread;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.subscriptions.Subscriptions;


public abstract class UseCase {
    private final PostExecutionThread postExecutionThread;
    private final BackgroundThread backgroundThread;
    protected Subscription subscription = Subscriptions.empty();

    public UseCase(PostExecutionThread postExecutionThread, BackgroundThread backgroundThread) {
        this.postExecutionThread = postExecutionThread;
        this.backgroundThread = backgroundThread;
    }

    protected abstract Observable buildUseCaseObservable();

    @SuppressWarnings("unchecked")
    public void execute(Subscriber subscriber) {
        this.subscription = this.buildUseCaseObservable()
                .subscribeOn(backgroundThread.getScheduler())
                .observeOn(postExecutionThread.getScheduler())
                .subscribe(subscriber);
    }

    public void unsubscribe() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
