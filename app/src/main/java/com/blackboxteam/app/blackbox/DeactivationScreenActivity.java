package com.blackboxteam.app.blackbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class DeactivationScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deactivation_screen);

        Button deactivateButton = (Button) findViewById(R.id.button_deactivate);

        deactivateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deactivateBlackbox(v);
            }
        });
    }

    public void deactivateBlackbox(View v) {

    }
}
