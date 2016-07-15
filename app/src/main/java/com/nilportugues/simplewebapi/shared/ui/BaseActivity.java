package com.nilportugues.simplewebapi.shared.ui;

import android.app.Activity;
import android.os.Bundle;

import butterknife.ButterKnife;


abstract public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
    }

    abstract protected int getLayoutId();
}
