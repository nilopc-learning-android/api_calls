package com.nilportugues.simplewebapi.users.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nilportugues.simplewebapi.R;
import com.nilportugues.simplewebapi.users.domain.services.GetUserService;
import com.nilportugues.simplewebapi.users.ui.view.UserProfileView;

import javax.inject.Inject;

import butterknife.BindView;

public class UserSearchActivity extends BaseActivity {


    @Inject GetUserService userDataQuery;
    @BindView(R.id.responseView) TextView responseView;
    @BindView(R.id.progressBar) ProgressBar progressBar;
    @BindView(R.id.emailText) EditText userIdField;
    @BindView(R.id.queryButton) Button queryButton;
    @BindView(R.id.button2) Button activity2;
    @BindView(R.id.button3) Button activity3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent().inject(this);
        loadUserAsyncTask();
        loadActivity2();
        loadActivity3();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    protected void loadActivity2() {
        activity2.setOnClickListener(view -> startActivity(new Intent(UserSearchActivity.this, Activity2.class)));
    }

    protected void loadActivity3() {
        activity3.setOnClickListener(view -> startActivity(new Intent(UserSearchActivity.this, Activity3.class)));
    }

    protected void loadUserAsyncTask() {
        queryButton.setOnClickListener(
                new UserProfileView(userDataQuery, userIdField, responseView, progressBar)
        );

    }
}
