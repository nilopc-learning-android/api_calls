package com.nilportugues.simplewebapi.users.ui.activities;

import com.nilportugues.simplewebapi.MyApplication;
import com.nilportugues.simplewebapi.shared.ui.activities.SharedBaseActivity;
import com.nilportugues.simplewebapi.users.di.components.UserComponent;


public abstract class BaseActivity extends SharedBaseActivity
{

    public UserComponent getComponent() {
        return ((MyApplication) getApplication()).getUserComponent();
    }

}
