package com.nilportugues.simplewebapi.users.ui.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nilportugues.simplewebapi.R;
import com.nilportugues.simplewebapi.users.domain.model.attributes.Email;
import com.nilportugues.simplewebapi.users.domain.usecase.FindUser;
import com.nilportugues.simplewebapi.users.ui.tasks.FetchUserProfile;

import javax.inject.Inject;

import butterknife.BindView;

public class UserSearchActivity extends BaseActivity {

    @Inject FindUser getUserDetails;
    @BindView(R.id.responseView) TextView responseView;
    @BindView(R.id.progressBar) ProgressBar progressBar;
    @BindView(R.id.emailText) EditText emailText;
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
            queryButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FetchUserProfile fetchUserProfile = new FetchUserProfile(
                            responseView,
                            progressBar,
                            emailFromEditText(emailText),
                            getUserDetails
                    );

                    fetchUserProfile.execute();
                }
            });
        }
    }

    private Email emailFromEditText(EditText emailText) {
        Email email = new Email();

        if (emailText != null && 0 != emailText.getText().length()) {
            email = new Email(emailText.getText().toString());
        }

        return email;
    }
}
