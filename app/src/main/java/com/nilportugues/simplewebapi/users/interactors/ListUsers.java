package com.nilportugues.simplewebapi.users.interactors;


import com.nilportugues.simplewebapi.shared.interactors.UseCase;
import com.nilportugues.simplewebapi.shared.threads.BackgroundThread;
import com.nilportugues.simplewebapi.shared.threads.PostExecutionThread;
import com.nilportugues.simplewebapi.users.domain.services.GetUsersService;

import rx.Observable;

public class ListUsers extends UseCase {

    private final GetUsersService getUsersService;

    public ListUsers(
            PostExecutionThread postExecutionThread,
            BackgroundThread backgroundThread,
            GetUsersService getUsersService
    ) {
        super(postExecutionThread, backgroundThread);
        this.getUsersService = getUsersService;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return getUsersService.execute();
    }
}
