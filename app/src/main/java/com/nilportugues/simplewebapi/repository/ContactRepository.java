package com.nilportugues.simplewebapi.repository;


import android.util.Log;

import com.nilportugues.simplewebapi.domain.model.attributes.Email;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ContactRepository {

    static final String API_KEY = "206398d0230dbb2f";
    static final String API_URL = "https://api.fullcontact.com/v2/person.json?";


    public String findByEmail(Email email)
    {
        if (email.getEmail().isEmpty()) {
            return "";
        }

        try {
            URL url = new URL(API_URL + "email=" + email.getEmail() + "&apiKey=" + API_KEY);
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
}
