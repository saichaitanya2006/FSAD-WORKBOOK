package com.klu.service;

import org.springframework.stereotype.Service;
import com.klu.entity.Student;
import com.klu.exception.StudentNotFoundException;

@Service
public class StudentService {

    public Student getStudentById(int id) {

        if (id == 1) {
            return new Student(1, "Sai", "CSE");
        }
        else if (id == 2) {
            return new Student(2, "Ravi", "ECE");
        }
        else {
            throw new StudentNotFoundException("Student with ID " + id + " not found");
        }
    }
}