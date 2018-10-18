package com.example.vaibh.gobiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }

    public void gotoCourses(View view) {
        Toast.makeText(this, "gotoCourse", Toast.LENGTH_SHORT).show();
    }

    public void gotoBadges(View view) {
        Toast.makeText(this, "gotoBadge", Toast.LENGTH_SHORT).show();
    }

    public void gotoNetwork(View view) {
        Toast.makeText(this, "gotoNetwork", Toast.LENGTH_SHORT).show();
    }

    public void gotoProfile(View view) {
        Toast.makeText(this, "gotoProfile", Toast.LENGTH_SHORT).show();
    }

    public void gotoSettings(View view) {
        Toast.makeText(this, "gotoSettings", Toast.LENGTH_SHORT).show();
    }

    public void gotoAbout(View view) {
        Toast.makeText(this, "gotoAbout", Toast.LENGTH_SHORT).show();
    }
}
