package com.nilportugues.simplewebapi.tasks;


import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nilportugues.simplewebapi.domain.model.attributes.Email;
import com.nilportugues.simplewebapi.network.userapi.transformers.User;
import com.nilportugues.simplewebapi.repository.ContactRepository;


public class RetrieveFeedTask extends AsyncTask<Void, Void, User> {


    private final TextView responseView;
    private final ProgressBar progressBar;
    private final Email email;
    private final ContactRepository contactRepository;

    public RetrieveFeedTask(TextView responseView, ProgressBar progressBar, Email email) {
        this.email = email;
        this.responseView = responseView;
        this.progressBar = progressBar;

        this.contactRepository = new ContactRepository();
    }

    protected void onPreExecute() {
        progressBar.setVisibility(View.VISIBLE);
        responseView.setText("");
    }

    protected User doInBackground(Void... urls) {
        return contactRepository.findByEmail(email);
    }

    protected void onPostExecute(User user) {

        progressBar.setVisibility(View.GONE);
        responseView.setText(
                "user: " + user.getName() + "\n" +
                        "email: " + user.getEmail()
        );
    }
}