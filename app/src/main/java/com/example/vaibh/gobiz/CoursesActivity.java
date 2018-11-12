package com.example.vaibh.gobiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.vaibh.gobiz.adapters.CoursesAdapter;
import com.example.vaibh.gobiz.pojos.Course;
import com.example.vaibh.gobiz.utils.MockData;
import com.google.firebase.database.DataSnapshot;

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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Intent intent = new Intent(getApplicationContext(), LessonActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
