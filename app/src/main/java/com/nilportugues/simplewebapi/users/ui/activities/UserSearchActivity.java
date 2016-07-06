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
import com.nilportugues.simplewebapi.users.domain.services.FindUser;
import com.nilportugues.simplewebapi.users.infrastructure.repository.model.User;

import javax.inject.Inject;

import butterknife.BindView;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class UserSearchActivity extends BaseActivity {

    @Inject
    FindUser getUserDetails;

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
                Observable<User> observable = getUserFromEmailAddress(email);

                observable
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

    private Observable<User> getUserFromEmailAddress(final Email email) {
        return Observable.create(
                new Observable.OnSubscribe<User>() {
                    @Override
                    public void call(Subscriber<? super User> subscriber) {
                        try {
                            User user = getUserDetails.byEmail(email);
                            subscriber.onNext(user);
                            subscriber.onCompleted();
                        } catch (Exception exception) {
                            subscriber.onError(exception);
                        }
                    }
                }
        );
    }

    private Email emailFromEditText(EditText emailText) {
        Email email = new Email();

        if (emailText != null && 0 != emailText.getText().length()) {
            email = new Email(emailText.getText().toString());
        }

        return email;
    }
}
