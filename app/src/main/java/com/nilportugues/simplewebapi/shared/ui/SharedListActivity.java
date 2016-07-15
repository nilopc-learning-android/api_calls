package com.nilportugues.simplewebapi.shared.ui;

import android.app.ListActivity;
import android.os.Bundle;

import butterknife.ButterKnife;

public abstract class SharedListActivity extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
    }

    abstract protected int getLayoutId();
}
