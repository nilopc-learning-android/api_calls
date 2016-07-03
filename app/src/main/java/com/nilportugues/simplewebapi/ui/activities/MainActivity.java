package com.nilportugues.simplewebapi.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nilportugues.simplewebapi.R;
import com.nilportugues.simplewebapi.domain.model.attributes.Email;
import com.nilportugues.simplewebapi.tasks.RetrieveFeedTask;


public class MainActivity extends AppCompatActivity {

    TextView responseView;
    ProgressBar progressBar;
    EditText emailText;
    Button queryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailText = (EditText) findViewById(R.id.emailText);
        responseView = (TextView) findViewById(R.id.responseView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        queryButton = (Button) findViewById(R.id.queryButton);


        Log.i("EMAIL",emailText.getText().toString());

        queryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetrieveFeedTask retrieveFeedTask = new RetrieveFeedTask(
                        responseView,
                        progressBar,
                        emailFromEditText(emailText)
                );

                retrieveFeedTask.execute();
            }
        });


    }

    private Email emailFromEditText(EditText emailText)
    {
        Email email = new Email();

        if(0 != emailText.getText().length()) {
            email = new Email(emailText.getText().toString());
        }

        return email;
    }
}
