package com.example.mydemo.controller;

import com.example.mydemo.model.Student;
import com.example.mydemo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/student")
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/create")
    public Student addStudent(@RequestBody Student student) {
        return studentService.addUser(student);
    }

    @GetMapping("getAllStudents")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/getStudentbyId/{id}")

    public Student getStudentbyId(@PathVariable("id") Long id) {
        return studentService.getStudentbyId(id);
    }

    @PutMapping("/updateStudent/{id}")
    public String updateStudent(@PathVariable("id") Long id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/deleteStudentById/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        return studentService.deleteStudent(id);
    }
}
