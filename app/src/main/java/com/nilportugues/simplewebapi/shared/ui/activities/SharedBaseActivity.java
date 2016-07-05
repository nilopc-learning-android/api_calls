package com.nilportugues.simplewebapi.shared.ui.activities;

import android.app.Activity;
import android.os.Bundle;


abstract public class SharedBaseActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
    }

    abstract protected int getLayoutId();

    abstract protected void getViewData();
}
