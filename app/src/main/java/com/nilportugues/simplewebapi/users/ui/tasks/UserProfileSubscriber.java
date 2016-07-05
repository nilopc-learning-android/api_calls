package com.nilportugues.simplewebapi.users.ui.tasks;


import com.nilportugues.simplewebapi.users.domain.model.attributes.Email;
import com.nilportugues.simplewebapi.users.domain.usecase.FindUser;
import com.nilportugues.simplewebapi.users.repository.model.User;

import rx.Subscriber;

public class UserProfileSubscriber extends Subscriber
{
    private FindUser getUserDetails;
    private User user;

    public UserProfileSubscriber(FindUser getUserDetails) {

        this.getUserDetails = getUserDetails;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {


    }

    @Override
    public void onNext(Object o) {
        Email email = (Email) o;
        user = getUserDetails.byEmail(email);
    }
}
