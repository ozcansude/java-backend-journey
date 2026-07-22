package com.ozcansude.practice;

public class Enrollment {
    private Course course;
    private double grade;

    Enrollment(Course course, double grade){
        this.setCourse(course);
        this.setGrade(grade);
    }


    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
