package com.nilportugues.simplewebapi.main.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.nilportugues.simplewebapi.users.ui.usersearch.UserSearchActivity;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, UserSearchActivity.class);
        startActivity(intent);
        finish();
    }
}
