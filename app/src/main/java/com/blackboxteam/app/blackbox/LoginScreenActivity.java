package com.blackboxteam.app.blackbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginScreenActivity extends AppCompatActivity implements View.OnClickListener {

    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        loginBtn = (Button) findViewById(R.id.button_login);
        loginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_login:
                Intent intent = new Intent(LoginScreenActivity.this, TestPage.class);
                startActivity(intent);
        }
    }
}
