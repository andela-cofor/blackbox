package com.blackboxteam.app.blackbox;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class LaunchScreenActivity extends AppCompatActivity {

    @BindView(R.id.launchScreenLoginButton)
    Button mloginScreen;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_screen);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.launchScreenLoginButton)
    public void launchScreenLoginButton (){
        Intent intent = new Intent(LaunchScreenActivity.this, LoginScreenActivity.class);
        startActivity(intent);
    }

    @Override
    protected void attachBaseContext (Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
