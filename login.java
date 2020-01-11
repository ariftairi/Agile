package com.blood.donation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import com.blood.donation.controller.PreferenceHelper;
import com.blood.donation.http.LoginRequest;

public class LoginActivity extends AppCompatActivity implements LoginRequest.LoginResponse {
    private AppCompatEditText username, password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        if (!PreferenceHelper.getToken(this).isEmpty()){
            goToMainScreen();
        }
    }

    public void doLogin(View view) {
        new LoginRequest(this).doLogin(username.getText().toString(), password.getText().toString());
    }

    @Override
    public void OnSuccess() {
        goToMainScreen();
    }

    @Override
    public void OnError(String msg) {
        Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_LONG).show();
    }

    private void goToMainScreen(){
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        finish();
    }

    public void signUp(View view) {
        startActivity(new Intent(LoginActivity.this, SignupActivity.class));
    }
}



