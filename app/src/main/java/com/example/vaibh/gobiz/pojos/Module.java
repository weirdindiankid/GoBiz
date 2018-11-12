package com.example.vaibh.gobiz.pojos;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;
import java.util.List;

public class Module {

    String courseName;
    String conclusion;
    String example;
    String exercise;
    String factoid;
    String homework;
    String introduction;
    String moduleNumber;
    String review;
    String successStory;
    String title;

    List<String> quizAnswers = new ArrayList<String>();
    List<String> quizQuestions = new ArrayList<String>();


    /**
     *
     * @param moduleNumber
     * @param contentSnapshot
     * @param courseName
     */

    public Module(String moduleNumber, DataSnapshot contentSnapshot, String courseName){
        this.courseName = courseName;
        this.moduleNumber = moduleNumber;
        Log.d("ModuleNumber", moduleNumber);
        Iterable<DataSnapshot> common =  contentSnapshot.child("Conclusion").child(moduleNumber).getChildren();
        for (DataSnapshot iter : common) {
            if (iter.getValue().toString() != null)
                Log.d("Conclusion Common" ,iter.getValue().toString());
                conclusion = iter.getValue().toString();
        }

        common = contentSnapshot.child("Example").child(moduleNumber).getChildren();
        for (DataSnapshot iter : common) {
            if (iter.getValue().toString() != null)
                example = iter.getValue().toString();
        }

        common = contentSnapshot.child("Exercise").child(moduleNumber).getChildren();
        for (DataSnapshot iter : common) {
            if (iter.getValue().toString() != null)
                exercise = iter.getValue().toString();
        }

        common = contentSnapshot.child("Factoid").child(moduleNumber).getChildren();
        for (DataSnapshot iter : common) {
            if (iter.getValue().toString() != null)
                factoid = iter.getValue().toString();
        }

        common = contentSnapshot.child("Homework").child(moduleNumber).getChildren();
        for (DataSnapshot iter : common) {
            if (iter.getValue().toString() != null)
                homework = iter.getValue().toString();
        }

        common = contentSnapshot.child("Introduction").child(moduleNumber).getChildren();
        for (DataSnapshot iter : common) {
            if (iter.getValue().toString() != null)
                introduction = iter.getValue().toString();
        }

        common = contentSnapshot.child("Review").child(moduleNumber).getChildren();
        for (DataSnapshot iter : common) {
            if (iter.getValue().toString() != null)
                review = iter.getValue().toString();
        }

        common = contentSnapshot.child("successStory").child(moduleNumber).getChildren();
        for (DataSnapshot iter : common) {
            if (iter.getValue().toString() != null)
                successStory = iter.getValue().toString();
        }

        common = contentSnapshot.child("Title").getChildren();

        for (DataSnapshot iter : common) {

            if (iter.getKey().equals(moduleNumber)) {
                Log.d("Title Common" ,iter.getValue().toString());
                title = iter.getValue().toString();
            }
        }


        Iterable<DataSnapshot> quiz_questions =  contentSnapshot.child("Quiz_Question").child(moduleNumber).getChildren();
        for (DataSnapshot iter : quiz_questions){
            if (iter.getValue().toString() != null)
                quizQuestions.add(iter.getValue().toString());
        }

            Iterable<DataSnapshot> quiz_answers =  contentSnapshot.child("Quiz_Answer").child(moduleNumber).getChildren();
        for (DataSnapshot iter : quiz_questions){
            if (iter.getValue().toString() != null)
                quizAnswers.add(iter.getValue().toString());
        }

        Log.d("Quiz", quizQuestions.toString());
        Log.d("Title",title);
    }

    /**
     *
     * @return quizAnswers
     */
    public List<String> getQuizAnswers() {
        return quizAnswers;
    }

    /**
     *
     * @return quizQuestions
     */
    public List<String> getQuizQuestions() {
        return quizQuestions;
    }

    /**
     *
     * @return conclusion
     */
    public String getConclusion() {
        return conclusion;
    }

    /**
     *
     * @return example
     */
    public String getExample() {
        return example;
    }


    /**
     *
     * @return exercise
     */
    public String getExercise() {
        return exercise;
    }


    /**
     *
     * @return factoid
     */
    public String getFactoid() {
        return factoid;
    }

    /**
     *
     * @return homework
     */
    public String getHomework() {
        return homework;
    }

    /**
     *
     * @return introduction
     */
    public String getIntroduction() {
        return introduction;
    }


    /**
     *
     * @return moduleNumber
     */
    public String getModuleNumber() {
        return moduleNumber;
    }

    /**
     *
     * @return review
     */
    public String getReview() {
        return review;
    }


    /**
     *
     * @return successStory
     */
    public String getSuccessStory() {
        return successStory;
    }

    /**
     *
     * @return title
     */
    public String getTitle() {
        return title;
    }
}
