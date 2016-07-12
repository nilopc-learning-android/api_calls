package com.nilportugues.simplewebapi.users.ui.presenter;

import com.nilportugues.simplewebapi.users.domain.services.GetUserService;

import javax.inject.Inject;


public class UserProfilePresenter
{
    @Inject
    GetUserService userDataQuery;

    public UserProfilePresenter(GetUserService userDataQuery) {
        this.userDataQuery = userDataQuery;
    }
}
