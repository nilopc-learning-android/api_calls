package com.nilportugues.simplewebapi.users.ui.activities.pager;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ProgressBar;

import com.nilportugues.simplewebapi.R;
import com.nilportugues.simplewebapi.shared.executors.IOThread;
import com.nilportugues.simplewebapi.shared.executors.UIThread;
import com.nilportugues.simplewebapi.users.domain.services.GetUsersService;
import com.nilportugues.simplewebapi.users.interactors.ListUsers;
import com.nilportugues.simplewebapi.users.repository.model.User;
import com.nilportugues.simplewebapi.users.ui.activities.BaseActivity;
import com.nilportugues.simplewebapi.users.ui.adapters.pager.UserListAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import rx.Subscriber;

public class Activity2 extends BaseActivity {

    @Inject GetUsersService getUsersService;
    @BindView(R.id.viewPager) ViewPager viewPager;
    @BindView(R.id.viewPagerProgressBar) ProgressBar progressBar;
    Context context;

    @Override
    protected int getLayoutId() {
        return R.layout.users_activity2;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent().inject(this);
        loadUserListAdapter();
        context = getApplicationContext();
    }

    private void loadUserListAdapter() {


        ListUsers listUsers = new ListUsers(new UIThread(), new IOThread(), getUsersService);
        listUsers.execute(new ListUsersSubscriber());
    }


    protected class ListUsersSubscriber extends Subscriber<List<User>> {

        private List<User> userList;

        @Override
        public void onCompleted() {
            UserListAdapter userListAdapter = new UserListAdapter(context, userList);
            viewPager.setAdapter(userListAdapter);
            progressBar.setVisibility(View.GONE);
        }

        @Override
        public void onError(Throwable e) {
            progressBar.setVisibility(View.GONE);
            UserListAdapter userListAdapter = new UserListAdapter(context, new ArrayList<>());
            viewPager.setAdapter(userListAdapter);
        }

        @Override
        public void onNext(List<User> users) {
          this.userList = users;
        }
    }
}
