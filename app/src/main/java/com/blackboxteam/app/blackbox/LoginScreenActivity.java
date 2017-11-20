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

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.blackboxteam.app.blackbox.util.Validation.validateEmail;
import static com.blackboxteam.app.blackbox.util.Validation.validateMinLength;

public class LoginScreenActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.btn_login) Button mLoginButton;
    @BindView(R.id.et_email) EditText mEditTextEmail;
    @BindView(R.id.et_password) EditText mEditTextPassword;
    @BindView(R.id.ti_email) TextInputLayout mTextInputEmail;
    @BindView(R.id.ti_password) TextInputLayout mTextInputPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        ButterKnife.bind(this);
        mLoginButton.setOnClickListener(this);
    }

    private void login() {
        setError();
        String email = mEditTextEmail.getText().toString();
        String password = mEditTextPassword.getText().toString();
        int err = 0;

        if (!validateEmail(email)) {
            err++;
            mTextInputEmail.setError("Email should be valid");
        }

        if (!validateMinLength(password, 8)) {
            err++;
            mTextInputPassword.setError("Password must be at least 8 characters");
        }

        if (err == 0) {
            Intent intent = new Intent(LoginScreenActivity.this, EmptyScreen.class);
            startActivity(intent);
        } else {
            showSnackBarMessage("Enter Valid Details !");
        }
    }

    private void setError() {
        mTextInputEmail.setError(null);
        mTextInputPassword.setError(null);
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
}
