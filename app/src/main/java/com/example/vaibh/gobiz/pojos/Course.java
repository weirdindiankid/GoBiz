package com.example.vaibh.gobiz.pojos;

import java.util.ArrayList;
import java.util.List;

public class Course {

    String courseName ;
    List<String> courseModules =  new ArrayList<String>();


    /**
     *
     * @param name
     * @param modules
     */

    public Course(String name, List<String> modules){

        courseName = name;
        courseModules = modules;


    }

    /**
     *
     * @return courseModules
     */
    public List<String> getCourseModules() {
        return courseModules;
    }

    /**
     *
     * @return courseName
     */
    public String getCourseName() {
        return courseName;
    }

}
