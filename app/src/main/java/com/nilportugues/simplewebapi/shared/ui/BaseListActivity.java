package com.nilportugues.simplewebapi.shared.ui;

import android.os.Bundle;

import butterknife.ButterKnife;

public abstract class BaseListActivity extends android.app.ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
    }

    abstract protected int getLayoutId();
}
