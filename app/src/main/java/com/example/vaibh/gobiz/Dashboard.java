package com.example.vaibh.gobiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

    }

    public void gotoCourses(View view) {
        Intent i = new Intent(getApplicationContext(), CoursesActivity.class);
        startActivity(i);
    }

    public void gotoBadges(View view) {
        Intent i = new Intent(getApplicationContext(), Badges.class);
        startActivity(i);
    }

    public void gotoNetwork(View view) {
        Intent i = new Intent(getApplicationContext(), Network.class);
        startActivity(i);
    }

    public void gotoProfile(View view) {
        Intent i = new Intent(getApplicationContext(), Profile.class);
        startActivity(i);
    }

    public void gotoSettings(View view) {
        Intent i = new Intent(getApplicationContext(), Settings.class);
        startActivity(i);
    }

    public void gotoAbout(View view) {
        Intent i = new Intent(getApplicationContext(), About.class);
        startActivity(i);
    }
}
