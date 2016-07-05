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
import com.nilportugues.simplewebapi.users.ui.rx.SearchByEmailSubscriber;

import javax.inject.Inject;

import butterknife.BindView;
import rx.Observable;
import rx.Subscriber;

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

    Email email;

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

            email = emailFromEditText(emailText);

            final Observable<Email> operationObservable = Observable.create(new Observable.OnSubscribe<Email>() {

                @Override
                public void call(Subscriber subscriber) {
                    subscriber.onNext(email);
                    subscriber.onCompleted();
                }

            });

            queryButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {

                    progressBar.setVisibility(View.VISIBLE);
                    responseView.setText("");

                    SearchByEmailSubscriber subscriber = new SearchByEmailSubscriber(
                            progressBar,
                            responseView,
                            getUserDetails
                    );

                    operationObservable.subscribe(subscriber);

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
