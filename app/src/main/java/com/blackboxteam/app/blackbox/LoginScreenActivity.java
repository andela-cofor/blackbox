package com.blackboxteam.app.blackbox;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.blackboxteam.app.blackbox.util.Validation;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

import static com.blackboxteam.app.blackbox.util.Validation.validateEmail;
import static com.blackboxteam.app.blackbox.util.Validation.validateMinLength;

public class LoginScreenActivity extends AppCompatActivity implements View.OnClickListener {

    Button loginBtn;
    EditText etEmail, etPassword;
    TextInputLayout tiEmail, tiPassword;
    Validation validate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        loginBtn = (Button) findViewById(R.id.btn_login);
        etEmail = (EditText) findViewById(R.id.et_email);
        etPassword = (EditText) findViewById(R.id.et_password);
        tiEmail = (TextInputLayout) findViewById(R.id.ti_email);
        tiPassword = (TextInputLayout) findViewById(R.id.ti_password);
        loginBtn.setOnClickListener(this);
    }

    private void login() {
        setError();
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        int err = 0;

        if (!validateEmail(email)) {
            err++;
            tiEmail.setError("Email should be valid");
        }

        if (!validateMinLength(password, 6)) {
            err++;
            tiPassword.setError("Password must be greater than 5");
        }

        if (err == 0) {
            Intent intent = new Intent(LoginScreenActivity.this, SignUpScreen.class);
            startActivity(intent);
        } else {
            showSnackBarMessage("Enter Valid Details !");
        }
    }

    private void setError() {
        tiEmail.setError(null);
        tiPassword.setError(null);
    }

    private void showSnackBarMessage(String message){
        Toast.makeText(LoginScreenActivity.this, message,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                login();
        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
