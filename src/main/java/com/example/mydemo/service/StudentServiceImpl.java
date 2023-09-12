package com.example.mydemo.service;

import com.example.mydemo.model.Student;
import com.example.mydemo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public Student addUser(Student student) {

        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentbyId(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException
                ("Student does not exist by given id" + id));
    }

    public String updateStudent(Long id, Student student) {
        Student existingStudent = studentRepository.findById(id).
                orElseThrow(() -> new RuntimeException("student not found"));
        existingStudent.setName(student.getName());
        studentRepository.save(existingStudent);
        return "Student updated successfully";
    }

    @Override
    public String deleteStudent(Long id) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("student not found"));
        studentRepository.deleteById(id);
        return "student with id" + id + "deleted successfully";

    }
}
