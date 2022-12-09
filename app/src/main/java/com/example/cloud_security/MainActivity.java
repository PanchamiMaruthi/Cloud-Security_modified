package com.example.cloud_security;

import static com.example.cloud_security.R.id.login_create;
import com.parse.Parse;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import androidx.appcompat.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseObject;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId(getString(R.string.back4app_app_id))
                .clientKey(getString(R.string.back4app_client_key))
                .server(getString(R.string.back4app_server_url))
                // at last we are building our
                // parse with the above credentials
                .build());

            // For Create in main page
            TextView create = findViewById(R.id.Create);

            create.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setContentView(R.layout.create);
                }
            });


        };
    }
