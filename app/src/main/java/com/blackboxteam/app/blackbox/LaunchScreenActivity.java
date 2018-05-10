package com.blackboxteam.app.blackbox;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.blackboxteam.app.blackbox.util.UserSessionPersistence;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class LaunchScreenActivity extends AppCompatActivity {

    UserSessionPersistence mUserSessionPersistence;
    @BindView(R.id.launchScreen)
    LinearLayout launchScreen;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_screen);
        ButterKnife.bind(this);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mUserSessionPersistence = new UserSessionPersistence(sharedPreferences);
//        mUserSessionPersistence.setActiveUserSession(true);

        if(mUserSessionPersistence.isActiveUserSession()) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        } else {
            launchScreen.setVisibility(View.VISIBLE);
        }
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
