package com.example.parstagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignupActivity extends AppCompatActivity {

    public static final String TAG = "SignupActivity";

    EditText etUsername;
    EditText etPassword;
    Button btnSignUp;
    ProgressBar pbSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnSignUp = findViewById(R.id.btnSignUp);
        pbSignup = findViewById(R.id.pbSignup);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pbSignup.setVisibility(ProgressBar.VISIBLE);
                // Get and validate EditText input
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                // Call createUser() helper function
                createUser(username, password);
            }
        });
    }

    private void createUser(String username, String password) {
        ParseUser user = new ParseUser();
        user.setUsername(username);
        user.setPassword(password);

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                pbSignup.setVisibility(ProgressBar.INVISIBLE);
                if (e != null) {
                    Log.e(TAG, "Error performing sign up", e);
                    Toast.makeText(SignupActivity.this, "Error signing up", Toast.LENGTH_SHORT).show();
                    return;
                }
                ParseUser.logOut();
                ParseUser currentUser = ParseUser.getCurrentUser();

                Intent i = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

}