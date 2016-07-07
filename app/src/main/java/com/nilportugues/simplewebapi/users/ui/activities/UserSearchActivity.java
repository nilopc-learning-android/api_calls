package com.nilportugues.simplewebapi.users.ui.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nilportugues.simplewebapi.R;
import com.nilportugues.simplewebapi.main.executors.IOThread;
import com.nilportugues.simplewebapi.main.executors.UIThread;
import com.nilportugues.simplewebapi.users.domain.model.attributes.UserId;
import com.nilportugues.simplewebapi.users.domain.services.UserDataQuery;
import com.nilportugues.simplewebapi.users.interactors.SearchUser;
import com.nilportugues.simplewebapi.users.repository.model.User;

import javax.inject.Inject;

import butterknife.BindView;
import rx.Subscriber;

public class UserSearchActivity extends BaseActivity {

    @Inject UserDataQuery userDataQuery;
    @BindView(R.id.responseView) TextView responseView;
    @BindView(R.id.progressBar) ProgressBar progressBar;
    @BindView(R.id.emailText) EditText userIdField;
    @BindView(R.id.queryButton) Button queryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent().inject(this);
        loadUserAsyncTask();
    }

    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    private void loadUserAsyncTask() {
        if (queryButton != null) {
            queryButton.setOnClickListener(v -> {
                progressBar.setVisibility(View.VISIBLE);

                SearchUser searchUser = new SearchUser(
                        new UIThread(),
                        new IOThread(),
                        userDataQuery,
                        UserSearchActivity.this.userIdFromField(userIdField)
                );
                searchUser.execute(new UISubscriber());
            });
        }
    }

    private class UISubscriber extends Subscriber<User>{

        @Override
        public void onCompleted() {
            progressBar.setVisibility(View.GONE);
        }

        @Override
        public void onError(Throwable e) {
            responseView.setText("user not found");
        }

        @Override
        public void onNext(User user) {
            responseView.setText("user: " + user.getName() + "\n" + "email: " + user.getEmail());

        }
    }

    private UserId userIdFromField(EditText editText) {
        UserId userId = new UserId();

        if (editText != null && 0 != editText.getText().length()) {
            userId = new UserId(editText.getText().toString());
        }

        return userId;
    }
}
