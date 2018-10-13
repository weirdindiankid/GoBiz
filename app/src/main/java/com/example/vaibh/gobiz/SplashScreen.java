package com.example.vaibh.gobiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SplashScreen extends AppCompatActivity {
    private Button btnLoginScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        btnLoginScreen = findViewById(R.id.btnLoginScreen);

        btnLoginScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), LoginScreen.class);
                startActivity(i);

            }
        });
    }
}
