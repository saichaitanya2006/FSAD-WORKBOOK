package com.klu.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CourseRegistration {

    @Value("102")
    private int rollNo;

    @Value("Sai")
    private String studentName;

    @Value("FSAD")
    private String courseName;

    @Value("4")
    private int semester;

    // Constructor Injection
    public CourseRegistration(
            @Value("102") int no,
            @Value("Sai") String name,
            @Value("FSAD") String cn,
            @Value("4") int sem) {

        this.rollNo = no;
        this.studentName = name;
        this.courseName = cn;
        this.semester = sem;
    }

    public void display() {
        System.out.println("RollNo      : " + rollNo);
        System.out.println("StudentName: " + studentName);
        System.out.println("CourseName : " + courseName);
        System.out.println("Semester   : " + semester);
    }
}
