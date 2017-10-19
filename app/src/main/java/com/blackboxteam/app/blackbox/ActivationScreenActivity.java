package com.blackboxteam.app.blackbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class ActivationScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activation_screen);

        Button secureButton = (Button) findViewById(R.id.button_secure);

        secureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendConfirmationMail(v);
            }
        });
    }

    public void sendConfirmationMail(View v) {

    }
}
