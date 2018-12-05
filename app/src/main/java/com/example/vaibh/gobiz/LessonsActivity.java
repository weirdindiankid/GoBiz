package com.example.vaibh.gobiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;

import com.example.vaibh.gobiz.adapters.LessonsAdapter;
import com.example.vaibh.gobiz.pojos.Course;
import com.example.vaibh.gobiz.pojos.Module;
import com.github.paolorotolo.expandableheightlistview.ExpandableHeightListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.example.vaibh.gobiz.CoursesActivity.COURSE_MODULE_MAP;
import static com.example.vaibh.gobiz.CoursesActivity.MODULES;

public class LessonsActivity extends AppCompatActivity {

    public ArrayList<Module> modules;
    public HashMap<Course, List<Module>> courseModuleMap;

    public static final String MODULE = "MODULE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons);

        Intent intent = getIntent();
        modules = intent.getParcelableArrayListExtra(MODULES);
        courseModuleMap = (HashMap<Course, List<Module>>) intent.getSerializableExtra(COURSE_MODULE_MAP);

        LessonsAdapter adapter = new LessonsAdapter(this, modules);
        ExpandableHeightListView lessonsList = findViewById(R.id.lessons_list);
        lessonsList.setExpanded(true);
        lessonsList.setFocusable(false);
        lessonsList.setAdapter(adapter);

        lessonsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), LessonActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable(MODULE, modules.get(i));
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

}
