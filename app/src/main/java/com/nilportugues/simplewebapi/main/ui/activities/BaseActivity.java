package com.nilportugues.simplewebapi.main.ui.activities;

import android.app.Activity;
import android.os.Bundle;

import com.nilportugues.simplewebapi.MyApplication;
import com.nilportugues.simplewebapi.main.MainComponent;


public abstract class BaseActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
    }

    public MainComponent getComponent()
    {
        return ((MyApplication) getApplication()).getMainComponent();
    }

    abstract protected int getLayoutId();
}
