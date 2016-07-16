package com.nilportugues.simplewebapi.users.ui;


import com.nilportugues.simplewebapi.MyApplication;
import com.nilportugues.simplewebapi.users.di.components.UserComponent;

abstract public class BaseFragmentActivity extends com.nilportugues.simplewebapi.shared.ui.BaseFragmentActivity {

    public UserComponent getComponent() {
        return ((MyApplication) getApplication()).getUserComponent();
    }
}
