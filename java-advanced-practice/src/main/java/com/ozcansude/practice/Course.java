package com.ozcansude.practice;

public class Course {
    private int courseId;
    private String courseName;

    Course(int courseId, String courseName){
        this.setCourseId(courseId);
        this.setCourseName(courseName);
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
