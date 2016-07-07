package com.nilportugues.simplewebapi.users.interactors;


import com.nilportugues.simplewebapi.main.interactors.UseCase;
import com.nilportugues.simplewebapi.main.threads.BackgroundThread;
import com.nilportugues.simplewebapi.main.threads.PostExecutionThread;
import com.nilportugues.simplewebapi.users.domain.model.attributes.UserId;
import com.nilportugues.simplewebapi.users.domain.services.UserDataQuery;

import rx.Observable;

public class SearchUser extends UseCase {

    private UserDataQuery userDataQuery;
    private UserId userId;

    public SearchUser(
            PostExecutionThread postExecutionThread,
            BackgroundThread backgroundThread,
            UserDataQuery userDataQuery,
            UserId email
    ) {
        super(postExecutionThread, backgroundThread);
        this.userDataQuery = userDataQuery;
        this.userId = email;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return userDataQuery.byUserId(userId);
    }
}
