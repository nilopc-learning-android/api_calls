package com.nilportugues.simplewebapi.main.ui.tasks;


import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nilportugues.simplewebapi.main.domain.model.attributes.Email;
import com.nilportugues.simplewebapi.main.domain.usecase.FindUser;
import com.nilportugues.simplewebapi.main.repository.datasource.userapi.transformers.User;


public class FetchUserProfile extends AsyncTask<Void, Void, User> {

    private TextView responseView;
    private ProgressBar progressBar;
    private Email email;
    private FindUser getUserDetails;

    public FetchUserProfile(TextView responseView, ProgressBar progressBar, Email email, FindUser getUserDetails) {
        this.email = email;
        this.responseView = responseView;
        this.progressBar = progressBar;
        this.getUserDetails = getUserDetails;
    }

    protected void onPreExecute() {
        progressBar.setVisibility(View.VISIBLE);
        responseView.setText("");
    }

    protected User doInBackground(Void... urls) {
        return getUserDetails.byEmail(email);
    }

    protected void onPostExecute(User user) {

        progressBar.setVisibility(View.GONE);
        responseView.setText(
                "user: " + user.getName() + "\n" +
                        "email: " + user.getEmail()
        );
    }
}