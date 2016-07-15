package com.nilportugues.simplewebapi.users.interactors;


import com.nilportugues.simplewebapi.shared.interactors.UseCase;
import com.nilportugues.simplewebapi.shared.threads.BackgroundThread;
import com.nilportugues.simplewebapi.shared.threads.PostExecutionThread;
import com.nilportugues.simplewebapi.users.domain.model.attributes.UserId;
import com.nilportugues.simplewebapi.users.domain.services.GetUserService;

import rx.Observable;

public class SearchUser extends UseCase {

    private final GetUserService userDataQuery;
    private final UserId userId;

    public SearchUser(
            GetUserService userDataQuery,
            UserId email
    ) {

        this.userDataQuery = userDataQuery;
        this.userId = email;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return userDataQuery.execute(userId);
    }
}
