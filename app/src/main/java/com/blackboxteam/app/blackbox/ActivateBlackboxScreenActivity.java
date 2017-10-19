package com.blackboxteam.app.blackbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class ActivateBlackboxScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activate_blackbox_screen);

        Button activateButton = (Button) findViewById(R.id.button_activate);

        activateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activateBlackbox(v);
            }
        });
    }

    public void activateBlackbox(View v) {

    }
}
