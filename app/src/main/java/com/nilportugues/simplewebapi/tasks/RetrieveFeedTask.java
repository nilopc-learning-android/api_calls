package com.nilportugues.simplewebapi.tasks;


import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nilportugues.simplewebapi.domain.model.attributes.Email;
import com.nilportugues.simplewebapi.repository.ContactRepository;


public class RetrieveFeedTask extends AsyncTask<Void, Void, String> {


    private final TextView responseView;
    private final ProgressBar progressBar;
    private final Email email;
    private final ContactRepository contactRepository;

    private Exception exception;

    public RetrieveFeedTask(TextView responseView, ProgressBar progressBar, Email email)
    {
        this.email = email;
        this.responseView = responseView;
        this.progressBar = progressBar;

        this.contactRepository = new ContactRepository();
    }

    protected void onPreExecute() {
        progressBar.setVisibility(View.VISIBLE);
        responseView.setText("");
    }

    protected String doInBackground(Void... urls) {

        String result = "";

        if (email.getEmail().length()>0) {
            result = contactRepository.findByEmail(email);
        }

        return result;
    }

    protected void onPostExecute(String response) {
        if(response == null) {
            response = "THERE WAS AN ERROR";
        }
        progressBar.setVisibility(View.GONE);
        Log.i("INFO", response);
        responseView.setText(response);
        // TODO: check this.exception
        // TODO: do something with the feed

//            try {
//                JSONObject object = (JSONObject) new JSONTokener(response).nextValue();
//                String requestID = object.getString("requestId");
//                int likelihood = object.getInt("likelihood");
//                JSONArray photos = object.getJSONArray("photos");
//                .
//                .
//                .
//                .
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
    }
}