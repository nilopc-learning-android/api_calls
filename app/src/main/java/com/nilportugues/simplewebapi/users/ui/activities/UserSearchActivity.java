package com.nilportugues.simplewebapi.users.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nilportugues.simplewebapi.R;
import com.nilportugues.simplewebapi.shared.executors.IOThread;
import com.nilportugues.simplewebapi.shared.executors.UIThread;
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
    @BindView(R.id.button2) Button activity2Button;
    @BindView(R.id.button3) Button activity3Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent().inject(this);
        loadUserAsyncTask();
        loadActivity2();
        loadActivity3();
    }

    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    protected void loadActivity2() {
            activity2Button.setOnClickListener(view -> {
                Intent intent = new Intent(UserSearchActivity.this, Activity2.class);
                startActivity(intent);
            });
    }

    protected void loadActivity3() {
            activity3Button.setOnClickListener(view -> {
                Intent intent = new Intent(UserSearchActivity.this, Activity3.class);
                startActivity(intent);
            });
    }

    protected void loadUserAsyncTask() {
        queryButton.setOnClickListener(v -> {
            progressBar.setVisibility(View.VISIBLE);

            UserId userId = new UserId();
            if (userIdField != null && 0 != userIdField.getText().length()) {
                userId = new UserId(userIdField.getText().toString());
            }

            SearchUser searchUser = new SearchUser(new UIThread(), new IOThread(), userDataQuery, userId);
            searchUser.execute(new UISubscriber());
        });

    }

    protected class UISubscriber extends Subscriber<User>{

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
}
