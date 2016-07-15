package com.nilportugues.simplewebapi.shared.interactors;

import com.nilportugues.simplewebapi.shared.threads.BackgroundThread;
import com.nilportugues.simplewebapi.shared.threads.PostExecutionThread;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.subscriptions.Subscriptions;


public abstract class UseCase {
    protected Subscription subscription = Subscriptions.empty();

    protected abstract Observable buildUseCaseObservable();

    @SuppressWarnings("unchecked")
    public void execute(
            PostExecutionThread postExecutionThread,
            BackgroundThread backgroundThread,
            Subscriber subscriber
    ) {
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
