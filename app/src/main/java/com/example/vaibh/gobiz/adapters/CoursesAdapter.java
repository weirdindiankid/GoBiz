package com.example.vaibh.gobiz.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.vaibh.gobiz.R;
import com.example.vaibh.gobiz.pojos.Course;
import com.github.lzyzsd.circleprogress.DonutProgress;

import java.util.ArrayList;

public class CoursesAdapter extends ArrayAdapter<Course> {

    public CoursesAdapter(Context context, ArrayList<Course> courses) {
        super(context, 0, courses);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Course course = getItem(position);
        assert course != null;

        // check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_course_item, parent, false);
        }

        // lookup view for data population
        DonutProgress donutProgress = convertView.findViewById(R.id.donutProgress);
        TextView nameView = convertView.findViewById(R.id.courseName);
        TextView descriptionView = convertView.findViewById(R.id.courseDescription);

        donutProgress.setDonut_progress(Integer.toString(course.getPercentComplete()));
        donutProgress.setText(Integer.toString(course.getPercentComplete()) + "%");
        nameView.setText(getContext().getString(R.string.course_item_title, Integer.toString(position + 1), course.getName()));
        descriptionView.setText(course.getDescription());

        return convertView;
    }
}
