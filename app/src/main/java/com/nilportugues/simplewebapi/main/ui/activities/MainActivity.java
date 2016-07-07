package com.nilportugues.simplewebapi.main.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.nilportugues.simplewebapi.users.ui.activities.UserSearchActivity;

public class MainActivity extends Activity {

    /**
     * Shows a pretty Splash and moves on to the next Activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, UserSearchActivity.class);
        startActivity(intent);
        finish();
    }
}
