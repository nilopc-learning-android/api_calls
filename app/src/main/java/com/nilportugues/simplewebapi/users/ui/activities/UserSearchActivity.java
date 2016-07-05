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

import javax.inject.Inject;

import butterknife.BindView;
import rx.Observable;
import rx.Subscriber;

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



    final Observable<String> operationObservable = Observable.create(new Observable.OnSubscribe<String>() {

        @Override
        public void call(Subscriber subscriber) {
            subscriber.onNext(doInBackgroundOperation());
            subscriber.onCompleted();
        }

    });


    private void loadUserAsyncTask() {
        if (queryButton != null) {



            queryButton.setOnClickListener(new View.OnClickListener() {



                @Override
                public void onClick(final View v) {

                    operationObservable.subscribe(new Subscriber<String>() {
                        @Override
                        public void onCompleted() {
                            progressBar.setVisibility(View.GONE);
                            responseView.setText("OK");
                        }

                        @Override
                        public void onError(Throwable e) {
                            responseView.setText("FAIL");
                        }

                        @Override
                        public void onNext(String string) {
                            progressBar.setVisibility(View.VISIBLE);
                            responseView.setText("");
                        }
                    });




                    /*FetchUserProfile fetchUserProfile = new FetchUserProfile(
                            responseView,
                            progressBar,
                            emailFromEditText(emailText),
                            getUserDetails
                    );

                    fetchUserProfile.execute();
                    */
                    /*UserProfileSubscriber subscriber = new UserProfileSubscriber(
                            responseView,
                            progressBar,
                            emailFromEditText(emailText),
                            getUserDetails
                    ).onNext();
                    */
                }
            });
        }
    }

    private String doInBackgroundOperation() {

        return "Complete!";
    }

    private Email emailFromEditText(EditText emailText) {
        Email email = new Email();

        if (emailText != null && 0 != emailText.getText().length()) {
            email = new Email(emailText.getText().toString());
        }

        return email;
    }
}
