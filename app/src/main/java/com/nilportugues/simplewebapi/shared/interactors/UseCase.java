package com.nilportugues.simplewebapi.shared.interactors;


import com.nilportugues.simplewebapi.shared.executor.PostExecutionThread;
import com.nilportugues.simplewebapi.shared.executor.ThreadExecutor;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

public abstract class UseCase {

    protected final ThreadExecutor threadExecutor;
    protected final PostExecutionThread postExecutionThread;
    protected Subscription subscription = Subscriptions.empty();

    public UseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }

    /**
     * Builds the {@link rx.Observable} that will be executed.
     */
    abstract protected Observable buildObservable();

    /**
     * Runs the Use Case using the provided Observable and executor Threads.
     */
    @SuppressWarnings("unchecked")
    public void execute(Subscriber subscriber) {

        this.subscription = this.buildObservable()
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.getScheduler())
                .subscribe(subscriber);
    }

    /**
     * Unsubscribes from current {@link rx.Subscription}.
     */
    public void unsubscribe() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
