package com.nilportugues.simplewebapi.users.ui.rx;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nilportugues.simplewebapi.users.domain.model.attributes.Email;
import com.nilportugues.simplewebapi.users.domain.usecase.FindUser;

import rx.Subscriber;


public class SearchByEmailSubscriber extends Subscriber<Email>{

    ProgressBar progressBar;
    TextView responseView;
    FindUser getUserDetails;

    public SearchByEmailSubscriber(ProgressBar progressBar, TextView responseView, FindUser getUserDetails) {
        this.progressBar = progressBar;
        this.responseView = responseView;
        this.getUserDetails = getUserDetails;
    }

    @Override
    public void onCompleted() {
        progressBar.setVisibility(View.GONE);
        responseView.setText("OK");
    }

    @Override
    public void onError(Throwable e) {
       responseView.setText("FAIL" + e.getClass());
    }

    @Override
    public void onNext(Email email) {
        getUserDetails.byEmail(email);

    }
}
