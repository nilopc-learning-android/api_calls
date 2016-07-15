package com.nilportugues.simplewebapi.users.ui.userpagerlist;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.ProgressBar;

import com.nilportugues.simplewebapi.R;
import com.nilportugues.simplewebapi.users.interactors.ListUsers;
import com.nilportugues.simplewebapi.users.ui.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;

public class UserListActivity extends BaseActivity {

    @Inject ListUsers interactor;
    @BindView(R.id.viewPager) ViewPager viewPager;
    @BindView(R.id.viewPagerProgressBar) ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent().inject(this);
        execute();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.users_activity2;
    }

    private void execute() {
        UserListView view = new UserListView(getApplicationContext(), viewPager, progressBar);
        UserListPresenter presenter = new UserListPresenter(interactor, view);
        presenter.subscribe();
    }
}
