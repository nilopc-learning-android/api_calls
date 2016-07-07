package com.nilportugues.simplewebapi.shared.ui.activities;

import android.app.Activity;
import android.os.Bundle;

import com.nilportugues.simplewebapi.MainComponent;
import com.nilportugues.simplewebapi.MyApplication;
import com.nilportugues.simplewebapi.main.di.HasComponent;

import butterknife.ButterKnife;


abstract public class SharedBaseActivity extends Activity implements HasComponent {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        this.getComponent().inject(this);
    }

    abstract protected int getLayoutId();

    public MainComponent getComponent() {
        return ((MyApplication) getApplication()).getApplicationComponent();
    }
}
