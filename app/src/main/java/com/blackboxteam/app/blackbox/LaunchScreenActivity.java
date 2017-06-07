package com.blackboxteam.app.blackbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class LaunchScreenActivity extends AppCompatActivity implements View.OnClickListener {

    Button nextScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_screen);

        nextScreen = (Button) findViewById(R.id.button_secure);
        nextScreen.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_secure:
                Intent intent = new Intent(LaunchScreenActivity.this, SignUpScreen.class);
                startActivity(intent);
        }
    }
}
