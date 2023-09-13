package com.example.bmi;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        TextView welcomeTextView = findViewById(R.id.welcomeTextView);

        // Retrieve the username from the Intent's Bundle
        String username = getIntent().getStringExtra("username");

        if (username != null) {
            welcomeTextView.setText("Welcome, " + username + "!");
        }
    }
}
