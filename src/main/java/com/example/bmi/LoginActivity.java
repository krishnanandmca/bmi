package com.example.bmi;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button signInButton;
    private TextView messageTextView;

    private int loginAttempts = 0;
    private final int MAX_ATTEMPTS = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        signInButton = findViewById(R.id.signInButton);


        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });
    }

    private void attemptLogin() {
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {

            Toast.makeText(getApplicationContext(),"Username and Password required",Toast.LENGTH_LONG).show();
            return;
        }

        if (!isPasswordValid(password)) {

            Toast.makeText(getApplicationContext(),"Password does not meet the criteria.",Toast.LENGTH_LONG).show();
            return;
        }

        // Check username and password (You can add your authentication logic here)

        if (username.equals("test") && password.equals("P@ssw0rf")) {
            Toast.makeText(getApplicationContext(),"Successfull login",Toast.LENGTH_LONG).show();
            // Transfer control to another activity with a welcome message
            Intent intent = new Intent(LoginActivity.this, WelcomeActivity.class);
            intent.putExtra("username", username);
            startActivity(intent);
            finish();
        } else {
            loginAttempts++;
            if (loginAttempts >= MAX_ATTEMPTS) {
                signInButton.setEnabled(false);

                Toast.makeText(getApplicationContext(),"Failed Login Attempts",Toast.LENGTH_LONG).show();

            } else {
                Toast.makeText(getApplicationContext(),"Login Failed",Toast.LENGTH_LONG).show();


            }
        }
    }

    private boolean isPasswordValid(String password) {
        // Implement password validation rules here (uppercase, lowercase, numbers, special characters, minimum length)
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
    }

    private void displayMessage(String message) {
        messageTextView.setText(message);
    }
}
