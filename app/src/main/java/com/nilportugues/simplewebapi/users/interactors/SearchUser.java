package com.nilportugues.simplewebapi.users.interactors;


import com.nilportugues.simplewebapi.users.domain.model.attributes.Email;
import com.nilportugues.simplewebapi.users.domain.services.UserDataQuery;
import com.nilportugues.simplewebapi.users.repository.model.User;

import rx.Observable;
import rx.Subscriber;

public class SearchUser {

    UserDataQuery userDataQuery;

    public SearchUser(UserDataQuery userDataQuery) {
        this.userDataQuery = userDataQuery;
    }

    public Observable<User> detailsFromEmail(final Email email) {
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
