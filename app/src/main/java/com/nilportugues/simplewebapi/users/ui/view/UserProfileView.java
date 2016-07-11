package com.nilportugues.simplewebapi.users.ui.view;


import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nilportugues.simplewebapi.shared.executors.IOThread;
import com.nilportugues.simplewebapi.shared.executors.UIThread;
import com.nilportugues.simplewebapi.users.domain.model.attributes.UserId;
import com.nilportugues.simplewebapi.users.domain.services.UserDataQuery;
import com.nilportugues.simplewebapi.users.interactors.SearchUser;
import com.nilportugues.simplewebapi.users.repository.model.User;

import rx.Subscriber;

public class UserProfileView implements View.OnClickListener{

    private final UserDataQuery userDataQuery;
    private final TextView responseView;
    private final ProgressBar progressBar;
    private final EditText userIdField;

    public UserProfileView(UserDataQuery userDataQuery, EditText userIdField, TextView responseView, ProgressBar progressBar) {
        this.userDataQuery = userDataQuery;
        this.userIdField = userIdField;
        this.responseView = responseView;
        this.progressBar = progressBar;
    }

    @Override
    public void onClick(View view) {
        progressBar.setVisibility(View.VISIBLE);

        UserId userId = new UserId();
        if (userIdField != null && 0 != userIdField.getText().length()) {
            userId = new UserId(userIdField.getText().toString());
        }

        SearchUser searchUser = new SearchUser(new UIThread(), new IOThread(), userDataQuery, userId);
        searchUser.execute(new UISubscriber());
    }

    protected class UISubscriber extends Subscriber<User> {

        @Override
        public void onCompleted() {
            progressBar.setVisibility(View.GONE);
        }

        @Override
        public void onError(Throwable e) {
            responseView.setText("user not found");
            progressBar.setVisibility(View.GONE);
        }

        @Override
        public void onNext(User user) {
            responseView.setText("user: " + user.getName() + "\n" + "email: " + user.getEmail());

        }
    }
}
