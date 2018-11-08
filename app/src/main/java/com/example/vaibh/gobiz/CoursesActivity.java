package com.example.vaibh.gobiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.vaibh.gobiz.adapters.CoursesAdapter;
import com.example.vaibh.gobiz.pojos.Course;
import com.example.vaibh.gobiz.utils.MockData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class CoursesActivity extends AppCompatActivity {
    private DataSnapshot courseDataFromDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        ArrayList<Course> courses = MockData.getMockCourses();
        CoursesAdapter coursesAdapter = new CoursesAdapter(this, courses);
        ListView listView = findViewById(R.id.courseList);
        listView.setAdapter(coursesAdapter);
    }
}
