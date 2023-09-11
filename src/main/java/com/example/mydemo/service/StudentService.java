package com.example.mydemo.service;

import com.example.mydemo.model.Student;

import java.util.List;

public interface StudentService {
Student addUser(Student student);
List<Student> getAllStudents();

Student getStudentbyId(Long id);
}

