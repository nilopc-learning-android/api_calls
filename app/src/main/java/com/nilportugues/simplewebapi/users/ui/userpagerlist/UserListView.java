package com.nilportugues.simplewebapi.users.ui.userpagerlist;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ProgressBar;

import com.nilportugues.simplewebapi.users.repository.model.User;

import java.util.ArrayList;
import java.util.List;


public class UserListView implements UserListContract.View {

    private List<User> mUserList;
    private Context mContext;
    private ViewPager mViewPager;
    private ProgressBar mProgressBar;
    private UserListContract.Presenter mPresenter;

    public UserListView(final Context context, final ViewPager viewPager, final ProgressBar progressBar) {
        mContext = context;
        mViewPager = viewPager;
        mProgressBar = progressBar;
    }

    @Override
    public void showLoading() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void setList(List<User> userList) {
        mUserList = userList;
    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showList() {
        UserListAdapter userListAdapter = new UserListAdapter(mContext, mUserList);
        mViewPager.setAdapter(userListAdapter);
    }

    @Override
    public void showErrorList() {
        UserListAdapter userListAdapter = new UserListAdapter(mContext, new ArrayList<>());
        mViewPager.setAdapter(userListAdapter);
    }

    @Override
    public void setPresenter(final UserListContract.Presenter presenter) {
        this.mPresenter = presenter;
    }
}
