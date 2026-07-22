package com.ozcansude.practice;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        Student student = new Student(3446, "Sude");
        Student student1 = new Student(3459, "Berke");

        Course course1 = new Course(1, "Java");
        Course course2 = new Course(2,"SQL");
        Course course3 = new Course(3,"Git");

        Enrollment enrollment = new Enrollment(course1, 90);
        Enrollment enrollment1 = new Enrollment(course2, 80);
        Enrollment enrollment2 = new Enrollment(course3, 70);

        student.addEnrollment(enrollment);
        student.addEnrollment(enrollment1);
        student.addEnrollment(enrollment2);

        Enrollment enrollment3 = new Enrollment(course1, 65);
        Enrollment enrollment4 = new Enrollment(course2, 90);
        Enrollment enrollment5 = new Enrollment(course3, 85);

        student1.addEnrollment(enrollment3);
        student1.addEnrollment(enrollment4);
        student1.addEnrollment(enrollment5);

        //--------------
        Course ai = new Course(4,"AI");
        Enrollment enrollment6 = new Enrollment(ai, 50);
        student.addEnrollment(enrollment6);
        // ---------------
        Enrollment enrollment7 = new Enrollment(ai, 80);
        student1.addEnrollment(enrollment7);
        // ---------------

        System.out.println("Student Name : " + student.getName());
        for(Enrollment e : student.getEnrollments()){
            System.out.println(e.getCourse().getCourseName()
                    +"---"
                    + e.getGrade());
        }
        System.out.println("Average : " +student.calculateAverage());

        System.out.println("************\nStudent Name : " + student1.getName());
        for(Enrollment e : student1.getEnrollments()){
            System.out.println(e.getCourse().getCourseName()
                    +"---"
                    + e.getGrade());
        }
        System.out.println("Average : " +student1.calculateAverage());


    }
}
