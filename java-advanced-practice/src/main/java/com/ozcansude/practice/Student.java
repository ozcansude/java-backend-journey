package com.ozcansude.practice;

import java.util.ArrayList;
import java.util.List;



public class Student {
    private int studentId;
    private String name;
    private List<Enrollment> enrollments =  new ArrayList<>();

    Student(int studentId, String name){
        this.studentId = studentId;

        this.name = name;
    }


    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    public double calculateAverage(){

        if(enrollments.isEmpty()){
            return 0.0;
        }

        double total = 0;

        for(Enrollment enrollment : enrollments){
            total += enrollment.getGrade();

        }

        return total / enrollments.size();
    }
    public void addEnrollment(Enrollment e){
        enrollments.add(e);
    }
}
