package com.nilportugues.simplewebapi.users.ui.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nilportugues.simplewebapi.R;
import com.nilportugues.simplewebapi.users.domain.model.attributes.Email;
import com.nilportugues.simplewebapi.users.domain.services.UserDataQuery;
import com.nilportugues.simplewebapi.users.interactors.SearchUser;
import com.nilportugues.simplewebapi.users.repository.model.User;

import javax.inject.Inject;

import butterknife.BindView;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class UserSearchActivity extends BaseActivity {

    @Inject
    UserDataQuery findUser;

    @BindView(R.id.responseView)
    TextView responseView;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.emailText)
    EditText emailText;

    @BindView(R.id.queryButton)
    Button queryButton;

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
                responseView.setText("");

                Email email = emailFromEditText(emailText);
                SearchUser userDetails = new SearchUser(findUser);

                userDetails
                        .detailsFromEmail(email)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                            this::addUserToResponseView,
                            this::userFromEmailAddressException,
                            this::hideProgressBar
                        );
            });
        }
    }

    private void addUserToResponseView(User user) {
        responseView.setText("user: " + user.getName() + "\n" + "email: " + user.getEmail());
    }

    private void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    private void userFromEmailAddressException(Throwable throwable) {
        Log.e("SEARCH_ERROR", throwable.getMessage());
    }

    private Email emailFromEditText(EditText emailText) {
        Email email = new Email();

        if (emailText != null && 0 != emailText.getText().length()) {
            email = new Email(emailText.getText().toString());
        }

        return email;
    }
}
