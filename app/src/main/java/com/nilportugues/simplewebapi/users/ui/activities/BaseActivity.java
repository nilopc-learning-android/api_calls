package com.nilportugues.simplewebapi.users.ui.activities;

import android.os.Bundle;

import com.nilportugues.simplewebapi.shared.ui.activities.SharedBaseActivity;
import com.nilportugues.simplewebapi.users.di.components.DaggerUserComponent;
import com.nilportugues.simplewebapi.users.di.modules.ApiModule;
import com.nilportugues.simplewebapi.users.di.modules.DomainServiceModule;
import com.nilportugues.simplewebapi.users.di.modules.RepositoryModule;


public abstract class BaseActivity extends SharedBaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerUserComponent
                .builder()
                .mainComponent(getComponent())
                .domainServiceModule(new DomainServiceModule())
                .repositoryModule(new RepositoryModule())
                .apiModule(new ApiModule())
                .build()
                .inject(this);
    }

}
