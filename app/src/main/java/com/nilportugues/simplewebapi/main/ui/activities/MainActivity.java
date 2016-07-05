package com.nilportugues.simplewebapi.main.ui.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nilportugues.simplewebapi.MyApplication;
import com.nilportugues.simplewebapi.R;
import com.nilportugues.simplewebapi.main.domain.model.attributes.Email;
import com.nilportugues.simplewebapi.main.domain.usecase.FindUser;
import com.nilportugues.simplewebapi.main.ui.tasks.FetchUserProfile;

import javax.inject.Inject;

public class MainActivity extends Activity {

    @Inject FindUser getUserDetails;

    private TextView responseView;
    private ProgressBar progressBar;
    private EditText emailText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MyApplication) getApplication()).getMainComponent().inject(this);

        setContentView(R.layout.activity_main);
        emailText = (EditText) findViewById(R.id.emailText);
        responseView = (TextView) findViewById(R.id.responseView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        Button queryButton = (Button) findViewById(R.id.queryButton);

        loadUserAsyncTask(queryButton);
    }

    private void loadUserAsyncTask(Button queryButton) {
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

        if (0 != emailText.getText().length()) {
            email = new Email(emailText.getText().toString());
        }

        return email;
    }
}
