package com.blackboxteam.app.blackbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class LaunchScreenActivity extends AppCompatActivity {
    public boolean text;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_screen);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.launchScreenLoginButton)
    public void launchLoginScreenActivity (){
        Intent intent = new Intent(LaunchScreenActivity.this, LoginScreenActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.launchScreenSignupButton)
    public void launchSignupScreenActivity (){
        Intent intent = new Intent(LaunchScreenActivity.this, SignUpScreenActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}
