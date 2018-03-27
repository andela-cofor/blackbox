package com.blackboxteam.app.blackbox;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.Button;
import android.widget.Toast;

import com.blackboxteam.app.blackbox.util.UserSessionPersistence;


import butterknife.ButterKnife;
import butterknife.OnClick;


public class LaunchScreenActivity extends AppCompatActivity {
    public boolean text;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_screen);
        ButterKnife.bind(this);
        saveUser();
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

    public void saveUser() {
        UserSessionPersistence userSessionPersistence = new UserSessionPersistence(getApplicationContext());
//        userSessionPersistence.saveUserInfo("ofor", "ofor");
        text = userSessionPersistence.checkLoginStatus("userInfo");
        String email = userSessionPersistence.getEmail("userInfo");

        String str = String.valueOf(text);

        Toast.makeText(LaunchScreenActivity.this, str,
                Toast.LENGTH_LONG).show();

    }
}
