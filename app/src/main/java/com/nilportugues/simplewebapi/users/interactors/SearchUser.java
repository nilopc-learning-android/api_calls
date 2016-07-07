package com.nilportugues.simplewebapi.users.interactors;


import com.nilportugues.simplewebapi.main.executors.BackgroundThread;
import com.nilportugues.simplewebapi.main.executors.PostExecutionThread;
import com.nilportugues.simplewebapi.main.interactors.UseCase;
import com.nilportugues.simplewebapi.users.domain.model.attributes.Email;
import com.nilportugues.simplewebapi.users.domain.services.UserDataQuery;
import com.nilportugues.simplewebapi.users.repository.model.User;

import rx.Observable;
import rx.Subscriber;

public class SearchUser extends UseCase {

    private UserDataQuery userDataQuery;
    private Email email;

    public SearchUser(
            PostExecutionThread postExecutionThread,
            BackgroundThread backgroundThread,
            UserDataQuery userDataQuery,
            Email email
    ) {
        super(postExecutionThread, backgroundThread);
        this.userDataQuery = userDataQuery;
        this.email = email;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return Observable.create(
                new Observable.OnSubscribe<User>() {
                    @Override
                    public void call(Subscriber<? super User> subscriber) {
                        try {
                            User user = userDataQuery.byEmail(email);
                            subscriber.onNext(user);
                            subscriber.onCompleted();
                        } catch (Exception exception) {
                            subscriber.onError(exception);
                        }
                    }
                }
        );
    }
}
