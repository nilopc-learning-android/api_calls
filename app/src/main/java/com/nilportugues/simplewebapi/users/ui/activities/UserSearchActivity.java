package com.nilportugues.simplewebapi.users.ui.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nilportugues.simplewebapi.R;
import com.nilportugues.simplewebapi.shared.executor.PostExecutionThread;
import com.nilportugues.simplewebapi.shared.executor.ThreadExecutor;
import com.nilportugues.simplewebapi.users.domain.model.attributes.Email;
import com.nilportugues.simplewebapi.users.domain.services.GetUserByEmail;
import com.nilportugues.simplewebapi.users.interactors.SearchUser;
import com.nilportugues.simplewebapi.users.repository.model.User;

import javax.inject.Inject;

import butterknife.BindView;
import rx.Subscriber;

public class UserSearchActivity extends BaseActivity {

    @Inject GetUserByEmail getUserByEmail;

    @Inject ThreadExecutor threadExecutor;
    @Inject PostExecutionThread postExecutionThread;

    @BindView(R.id.responseView) TextView responseView;
    @BindView(R.id.progressBar) ProgressBar progressBar;
    @BindView(R.id.emailText) EditText emailText;
    @BindView(R.id.queryButton) Button queryButton;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                        threadExecutor,
                        postExecutionThread,
                        emailFromEditText(emailText)
                );



                searchUser.execute(new UISubscriber());

                /*
                userDetails
                        .execute(email)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                            this::onNextUserDetails,
                            this::onErrorUserDetails,
                            this::onCompleteUserDetails
                        );
                        */
            });
        }
    }

    protected class UISubscriber extends Subscriber<User>{

        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            Log.e("SEARCH_ERROR", e.getMessage());
        }

        @Override
        public void onNext(User user) {
            responseView.setText("user: " + user.getName() + "\n" + "email: " + user.getEmail());
            progressBar.setVisibility(View.GONE);
        }
    }

    private Email emailFromEditText(EditText emailText) {
        Email email = new Email();

        if (emailText != null && 0 != emailText.getText().length()) {
            email = new Email(emailText.getText().toString());
        }

        Log.i("EMAIL_VAL", email.toString());

        return email;
    }
}
