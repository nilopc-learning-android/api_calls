package com.nilportugues.simplewebapi.users.interactors;


import com.nilportugues.simplewebapi.shared.executor.PostExecutionThread;
import com.nilportugues.simplewebapi.shared.executor.ThreadExecutor;
import com.nilportugues.simplewebapi.shared.interactors.UseCase;
import com.nilportugues.simplewebapi.users.domain.model.attributes.Email;
import com.nilportugues.simplewebapi.users.domain.services.GetUserByEmail;

import javax.inject.Inject;

import rx.Observable;

public class SearchUser extends UseCase{

    @Inject
    GetUserByEmail getUserByEmail;

    private Email email;

    public SearchUser(
            ThreadExecutor threadExecutor,
            PostExecutionThread postExecutionThread,
            Email email
    ) {
        super(threadExecutor, postExecutionThread);
        this.email = email;
    }

    @Override
    protected Observable buildObservable() {
        return getUserByEmail.execute(this.email);
    }
}
