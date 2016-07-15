package com.nilportugues.simplewebapi.users.interactors;


import com.nilportugues.simplewebapi.shared.interactors.UseCase;
import com.nilportugues.simplewebapi.users.domain.services.GetUsersService;

import rx.Observable;

public class ListUsers extends UseCase {

    private final GetUsersService getUsersService;

    public ListUsers(GetUsersService getUsersService) {
        this.getUsersService = getUsersService;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return getUsersService.execute();
    }
}
