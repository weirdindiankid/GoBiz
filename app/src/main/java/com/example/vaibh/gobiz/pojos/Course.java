package com.example.vaibh.gobiz.pojos;

public class Course {

    private String name;
    private String description;
    private boolean isUnlocked;
    private int completionPercentage;

    public Course(String name, String description, boolean isUnlocked, int percentComplete) {
        this.name = name;
        this.description = description;
        this.isUnlocked = isUnlocked;
        this.completionPercentage = percentComplete;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isUnlocked() {
        return isUnlocked;
    }

    public void setUnlocked(boolean unlocked) {
        isUnlocked = unlocked;
    }

    public int getPercentComplete() {
        return completionPercentage;
    }

    public void setPercentComplete(int completionPercentage) {
        this.completionPercentage = completionPercentage;
    }
}
