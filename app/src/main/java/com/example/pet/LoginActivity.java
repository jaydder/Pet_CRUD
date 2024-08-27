package com.example.pet;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText field_login;
    EditText field_password;
    Button button_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        field_login = findViewById(R.id.field_login);
        field_password = findViewById(R.id.field_password);
        button_login = findViewById(R.id.btn_list);

        button_login.setOnClickListener(v -> login());
    }

    public void login() {
        String login = field_login.getText().toString();
        String password = field_password.getText().toString();

        verifyFieldsEmpty();

        if (checkLogin(login, password)) {
            Intent intent = new Intent(this, DashBoardActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Login or password is incorrect", Toast.LENGTH_SHORT).show();
        }
    }

    public void loginEmptyError() {
        field_login.setError("Login is empty");
    }

    public void passwordEmptyError() {
        field_password.setError("Password is empty");
    }

    public void verifyFieldsEmpty() {
        if (field_login.getText().toString().isEmpty()) {
            loginEmptyError();
        } else if (field_password.getText().toString().isEmpty()) {
            passwordEmptyError();
        }
    }
    public boolean checkLogin(String login, String password) {
        return login.equals("admin") && password.equals("admin");
    }
}

