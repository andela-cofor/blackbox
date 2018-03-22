package com.blackboxteam.app.blackbox;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class LaunchScreenActivity extends AppCompatActivity {

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
    protected void attachBaseContext (Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
