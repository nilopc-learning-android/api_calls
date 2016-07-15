package com.nilportugues.simplewebapi.users.ui.usersearch;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nilportugues.simplewebapi.R;
import com.nilportugues.simplewebapi.users.domain.services.GetUserService;
import com.nilportugues.simplewebapi.users.ui.BaseActivity;
import com.nilportugues.simplewebapi.users.ui.userfragmentview.FragmentActivity;
import com.nilportugues.simplewebapi.users.ui.userpager.Activity2;
import com.nilportugues.simplewebapi.users.ui.usertabsscrollable.TabsScrollableActivity;
import com.nilportugues.simplewebapi.users.ui.usertabscustomview.TabsWithCustomViewsActivity;
import com.nilportugues.simplewebapi.users.ui.usertabsicons.TabsWithIconsActivity;
import com.nilportugues.simplewebapi.users.ui.usetabstext.TabsWithTextActivity;
import com.nilportugues.simplewebapi.users.ui.userprofile.UserProfileView;

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

    @BindView(R.id.tabs1) Button tabs1;
    @BindView(R.id.tabs2) Button tabs2;
    @BindView(R.id.tabs3) Button tabs3;
    @BindView(R.id.tabs4) Button tabs4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent().inject(this);
        loadUserAsyncTask();
        loadActivity2();
        loadActivity3();

        loadActivityTabs1();
        loadActivityTabs2();
        loadActivityTabs3();
        loadActivityTabs4();
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    protected void loadActivity2() {
        activity2.setOnClickListener(view -> startActivity(new Intent(UserSearchActivity.this, Activity2.class)));
    }

    protected void loadActivity3() {
        activity3.setOnClickListener(view -> startActivity(new Intent(UserSearchActivity.this, FragmentActivity.class)));
    }

    protected void loadUserAsyncTask() {
        queryButton.setOnClickListener(new UserProfileView(userDataQuery, userIdField, responseView, progressBar));
    }

    protected void loadActivityTabs1() {
        tabs1.setOnClickListener(view -> startActivity(new Intent(UserSearchActivity.this, TabsWithTextActivity.class)));
    }

    protected void loadActivityTabs2() {
        tabs2.setOnClickListener(view -> startActivity(new Intent(UserSearchActivity.this, TabsWithIconsActivity.class)));
    }

    protected void loadActivityTabs3() {
        tabs3.setOnClickListener(view -> startActivity(new Intent(UserSearchActivity.this, TabsScrollableActivity.class)));
    }

    protected void loadActivityTabs4() {
        tabs4.setOnClickListener(view -> startActivity(new Intent(UserSearchActivity.this, TabsWithCustomViewsActivity.class)));
    }

}
