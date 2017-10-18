package com.blackboxteam.app.blackbox;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.blackboxteam.app.blackbox.util.Validation;

import static com.blackboxteam.app.blackbox.util.Validation.validateEmail;
import static com.blackboxteam.app.blackbox.util.Validation.validateMinLength;
import static com.blackboxteam.app.blackbox.util.Validation.validateSpecialCharacters;

public class SignUpScreen extends AppCompatActivity implements View.OnClickListener {

    Button signinBtn;
    EditText etEmail, etPassword;
    TextInputLayout tiEmail, tiPassword;
    Validation validate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_screen);

        signinBtn = (Button) findViewById(R.id.btn_signin);
        signinBtn.setOnClickListener(this);
        etEmail = (EditText) findViewById(R.id.et_email);
        etPassword = (EditText) findViewById(R.id.et_password);
        tiEmail = (TextInputLayout) findViewById(R.id.ti_email);
        tiPassword = (TextInputLayout) findViewById(R.id.ti_password);
    }

    private void setError() {
        tiEmail.setError(null);
        tiPassword.setError(null);
    }

    private void signIn() {
        setError();
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        
        int err = 0;

        if(!validateEmail(email)) {
            err++;
            tiEmail.setError("Please enter a valid email");
        }

        if (!validateMinLength(password, 8)) {
            err++;
            tiPassword.setError("Password must be at least 8 characters");
        }

        if (!validateSpecialCharacters(password)) {
            err++;
            tiPassword.setError("Password contains special characters");
        }

        if (err == 0) {
            Intent intent = new Intent(SignUpScreen.this, EmptyScreen.class);
            startActivity(intent);
        } else {
            showSnackBarMessage("Enter Valid Details !");
        }
    }

    private void showSnackBarMessage(String message){
        Toast.makeText(SignUpScreen.this, message,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_signin:
                signIn();
        }
    }
}
