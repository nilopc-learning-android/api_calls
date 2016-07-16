package com.nilportugues.simplewebapi.users.ui.userpagerlist;

import com.nilportugues.simplewebapi.shared.executors.IOThread;
import com.nilportugues.simplewebapi.shared.executors.UIThread;
import com.nilportugues.simplewebapi.users.interactors.ListUsers;
import com.nilportugues.simplewebapi.users.repository.model.User;

import java.util.List;

import rx.Subscriber;

public class UserListPresenter implements UserListContract.Presenter {

    private UserListContract.View mUserListView;
    private ListUsers mInteractor;

    public UserListPresenter(ListUsers interactor, UserListContract.View userListView) {
        mInteractor = interactor;
        mUserListView = userListView;
        mUserListView.setPresenter(this);
    }

    @Override
    public void setUserList(List<User> userList) {
        mUserListView.setUserList(userList);
    }

    @Override
    public void showLoading(boolean active) {
        if (active) {
            mUserListView.showLoading();
            return;
        }
        mUserListView.hideLoading();
    }

    @Override
    public void showList(boolean complete) {
        showLoading(false);

        if (complete) {
            mUserListView.showList();
            return;
        }
        mUserListView.showErrorList();
    }

    @Override
    public void subscribe() {
        showLoading(true);
        mInteractor.execute(new UIThread(), new IOThread(), new UserListSubscriber());
    }

    @Override
    public void unsubscribe() {
        mInteractor.unsubscribe();
    }

    /**
     * Controls the logic of the presenter based on the use-case behavior.
     */
    protected class UserListSubscriber extends Subscriber<List<User>> {
        @Override
        public void onCompleted() {
            showList(true);
        }

        @Override
        public void onError(Throwable e) {
            showList(false);
        }

        @Override
        public void onNext(List<User> users) {
            setUserList(users);
        }
    }
}
