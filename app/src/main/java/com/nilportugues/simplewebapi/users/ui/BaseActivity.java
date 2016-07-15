package com.nilportugues.simplewebapi.users.ui;

import com.nilportugues.simplewebapi.MyApplication;
import com.nilportugues.simplewebapi.shared.ui.SharedBaseActivity;
import com.nilportugues.simplewebapi.users.di.components.UserComponent;


public abstract class BaseActivity extends SharedBaseActivity {

    public UserComponent getComponent() {
        return ((MyApplication) getApplication()).getUserComponent();
    }

}
