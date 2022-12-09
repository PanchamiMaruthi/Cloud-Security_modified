package com.example.cloud_security;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class create extends AppCompatActivity  {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        EditText email, password;
        Button confirm;

        email = findViewById(R.id.create_email);
        password = findViewById(R.id.create_password);
        confirm = findViewById(R.id.create_new);

        String email1 = email.getText().toString();
        String password1 = password.getText().toString();


        // checking if the entered text is empty or not.
        if (TextUtils.isEmpty(email1) && TextUtils.isEmpty(password1)) {
            Toast.makeText(getApplicationContext(), "Please enter email and password", Toast.LENGTH_SHORT).show();

            registerUser(password1, email1);
        }
    };

    void registerUser(String password, String email) {

        // on below line we are creating
        // a new user using parse user.
        ParseUser user = new ParseUser();

        // Set the user's username, user email and password,
        // which can be obtained from edit text
        user.setEmail(email);
        user.setPassword(password);

        // calling a method to register the user.
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                // on user registration checking
                // if the error is null or not.
                if (e == null) {
                    // if the error is null we are displaying a toast message and
                    // redirecting our user to login activity and passing the user name.
                    Toast.makeText(getApplicationContext(), "User Registered successfully \n Please verify your email", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    i.putExtra("password", password);
                    startActivity(i);
                } else {
                    // if we get any error then we are logging out
                    // our user and displaying an error message
                    ParseUser.logOut();
                    Toast.makeText(getApplicationContext(), "Fail to Register User..", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}


