package com.example.mydemo.service;

import com.example.mydemo.dto.requestDto.StudentRequestDto;
import com.example.mydemo.dto.responseDto.StudentResponseDto;
import com.example.mydemo.model.Student;

import java.util.List;

public interface StudentService {
    Student addUser(StudentRequestDto studentRequestDto);

    //to get all the students
    List<StudentResponseDto> getAllStudents();

    //to get info about information by id
    StudentResponseDto getStudentbyId(Long id);

    //to update the info of the students
    String updateStudent(Long id, StudentRequestDto studentRequestDto);

    //to delete the info about the student
    String deleteStudent(Long id);
}

