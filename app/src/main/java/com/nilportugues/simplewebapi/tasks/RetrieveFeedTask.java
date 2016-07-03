package com.nilportugues.simplewebapi.tasks;


import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class RetrieveFeedTask extends AsyncTask<Void, Void, String> {

    static final String API_KEY = "206398d0230dbb2f";
    static final String API_URL = "https://api.fullcontact.com/v2/person.json?";

    private final TextView responseView;
    private final ProgressBar progressBar;
    private final String emailText;

    private Exception exception;

    public RetrieveFeedTask(TextView responseView, ProgressBar progressBar, String emailText)
    {
        this.responseView = responseView;
        this.emailText = emailText;
        this.progressBar = progressBar;
    }

    protected void onPreExecute() {
        progressBar.setVisibility(View.VISIBLE);
        responseView.setText("");
    }

    protected String doInBackground(Void... urls) {
        // Do some validation here

        try {
            URL url = new URL(API_URL + "email=" + emailText + "&apiKey=" + API_KEY);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
                bufferedReader.close();
                return stringBuilder.toString();
            }
            finally{
                urlConnection.disconnect();
            }
        }
        catch(Exception e) {
            Log.e("ERROR", e.getMessage(), e);
            return null;
        }
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