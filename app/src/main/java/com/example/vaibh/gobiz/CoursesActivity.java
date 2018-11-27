package com.example.vaibh.gobiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.vaibh.gobiz.adapters.CoursesAdapter;
import com.example.vaibh.gobiz.pojos.Course;
import com.example.vaibh.gobiz.pojos.Module;
import com.example.vaibh.gobiz.utils.DatabaseConnection;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CoursesActivity extends AppCompatActivity {
    public List<Module> modules = new ArrayList<>();
    public HashMap<Course, List<Module>> courseModuleMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);
        collectData();

        ListView courseList = findViewById(R.id.courseList);
        courseList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    // todo: use/pass data from the db
                    Intent intent = new Intent(getApplicationContext(), LessonActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    public void collectData() {
        DatabaseConnection dao = new DatabaseConnection();
        Query getData = dao.mDatabase;

        getData.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Iterable<DataSnapshot> courseSnapshots = dataSnapshot.child("Courses").getChildren();
                for (DataSnapshot courseIter : courseSnapshots) {
                    Map<String, List<String>> modulesFromCourses = new HashMap<>();
                    List<String> modsList = new ArrayList<>();
                    for (DataSnapshot mods : courseIter.getChildren()) {
                        for (DataSnapshot extract : mods.getChildren()) {
                            if (extract.getValue().toString() != null)
                                Log.d(" Data Snapshot Value ", extract.getValue().toString());
                            modsList.add(extract.getValue().toString());
                        }
                    }

                    modulesFromCourses.put(courseIter.getKey(), modsList);
                    //modulesFromCourses = (HashMap<String, String>) courseIter.child("Modules").getValue();
                    Log.d(" Data Snapshot Value ", modulesFromCourses.toString());
                    modules = new ArrayList<>();
                    for (String mod : modsList) {
                        Log.d("DataSnapshot module ", mod);
                        Module modObj = new Module(mod, dataSnapshot.child("Content"), courseIter.getKey());
                        modules.add(modObj);
                    }
                    Course entry = new Course(courseIter.getKey(), modsList);
                    Log.d("Tagsssss ::::", entry.getCourseName());
                    courseModuleMap.put(entry, modules);
                    Log.d("Map :::: ", courseModuleMap.toString());

                }
                Set<Course> courses = courseModuleMap.keySet();
                ArrayList<Course> courseList = new ArrayList<>();
                courseList.addAll(courses);
                Log.d("Before Adapter call :", Integer.toString(courses.size()));
                CoursesAdapter coursesAdapter = new CoursesAdapter(getApplicationContext(), courseList);
                ListView listView = findViewById(R.id.courseList);
                listView.setAdapter(coursesAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
