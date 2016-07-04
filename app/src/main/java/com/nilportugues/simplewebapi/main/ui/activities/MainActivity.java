package com.nilportugues.simplewebapi.main.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nilportugues.simplewebapi.R;
import com.nilportugues.simplewebapi.main.DaggerMainComponent;
import com.nilportugues.simplewebapi.main.MainComponent;
import com.nilportugues.simplewebapi.main.MainModule;
import com.nilportugues.simplewebapi.main.domain.model.attributes.Email;
import com.nilportugues.simplewebapi.main.domain.usecase.FindUser;
import com.nilportugues.simplewebapi.main.ui.tasks.FetchUserProfile;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity {

    @Inject
    FindUser getUserDetails;
    private TextView responseView;
    private ProgressBar progressBar;
    private EditText emailText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent().inject(this);

        setContentView(R.layout.activity_main);
        emailText = (EditText) findViewById(R.id.emailText);
        responseView = (TextView) findViewById(R.id.responseView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        Button queryButton = (Button) findViewById(R.id.queryButton);

        if (queryButton != null) {
            loadUserAsyncTask(queryButton);
        }
    }

    private void loadUserAsyncTask(Button queryButton) {
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

    /**
     * Piles up all the dependencies and will dynamically inject them accordingly.
     */
    public MainComponent getComponent() {
        return DaggerMainComponent
                .builder()
                .mainModule(new MainModule())
                .build();
    }


    private Email emailFromEditText(EditText emailText) {
        Email email = new Email();

        if (0 != emailText.getText().length()) {
            email = new Email(emailText.getText().toString());
        }

        return email;
    }
}
