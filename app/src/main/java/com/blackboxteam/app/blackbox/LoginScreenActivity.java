package com.blackboxteam.app.blackbox;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;

import com.blackboxteam.app.blackbox.util.Validation;

import static com.blackboxteam.app.blackbox.util.Validation.validateEmail;
import static com.blackboxteam.app.blackbox.util.Validation.validateMinLength;

public class LoginScreenActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.button_login) Button loginButton;
    @BindView(R.id.edit_text_email) EditText editTextEmail;
    @BindView(R.id.edit_text_password) EditText editTextPassword;
    @BindView(R.id.text_input_email) TextInputLayout textInputEmail;
    @BindView(R.id.text_input_password) TextInputLayout textInputPassword;

    public Validation validate;
    private Integer password_length = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        ButterKnife.bind(this);

        loginButton.setOnClickListener(this);
    }

    private void login() {
        clearErrorMessage();
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();

        int err = 0;

        if (!validateEmail(email)) {
            err++;
            textInputEmail.setError("Email should be valid");
        }

        if (!validateMinLength(password, password_length)) {
            err++;
            textInputPassword.setError("Password must be greater than " + (password_length - 1));
        }

        if (err == 0) {
            Intent intent = new Intent(LoginScreenActivity.this, ActivateBlackboxScreenActivity.class);
            startActivity(intent);
        } else {
            showSnackBarMessage("Enter Valid Details !");
        }
    }

    private void clearErrorMessage() {
        textInputEmail.setError(null);
        textInputPassword.setError(null);
    }

    private void showSnackBarMessage(String message){
        Toast.makeText(LoginScreenActivity.this, message,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_login:
                login();
        }
    }
}
