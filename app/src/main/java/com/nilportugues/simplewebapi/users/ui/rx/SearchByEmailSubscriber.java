package com.nilportugues.simplewebapi.users.ui.rx;

import com.nilportugues.simplewebapi.users.domain.model.attributes.Email;
import com.nilportugues.simplewebapi.users.domain.usecase.FindUser;
import com.nilportugues.simplewebapi.users.repository.model.User;

import rx.Subscriber;


public class SearchByEmailSubscriber extends Subscriber<Email> {

    FindUser getUserDetails;
    User user;

    public SearchByEmailSubscriber(FindUser getUserDetails) {
        this.getUserDetails = getUserDetails;
    }

    @Override
    public void onCompleted() {
        System.out.println(user.getName());
    }

    @Override
    public void onError(Throwable e) {
        System.out.println("FAIL");
    }

    @Override
    public void onNext(Email email) {
        user = getUserDetails.byEmail(email);
    }
}
