package com.example.vaibh.gobiz.pojos;

import java.util.ArrayList;
import java.util.List;

public class Course {

    String courseName ;
    List<String> courseModules =  new ArrayList<String>();
    String courseDescription ;

    /**
     *
     * @param name
     * @param modules
     */

    public Course(String name, List<String> modules){

        courseName = name;
        courseModules = modules;
        courseDescription = "Description to be added later as we get more data";


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

    /**
     *
     * @return courseDescription
     */
    public String getCourseDescription() {
        return courseDescription;
    }
}
