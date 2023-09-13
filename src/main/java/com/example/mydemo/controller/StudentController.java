package com.example.mydemo.controller;

import com.example.mydemo.dto.requestDto.StudentRequestDto;
import com.example.mydemo.dto.responseDto.StudentResponseDto;
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
    public Student addStudent(@RequestBody StudentRequestDto studentRequestDto) {
        return studentService.addUser(studentRequestDto);
    }

    @GetMapping("getAllStudents")
    //as we are getting list of StudentResponsesDto we have to change List<Student> to List<StudentResponseDto>
    public List<StudentResponseDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/getStudentbyId/{id}")

    public StudentResponseDto getStudentbyId(@PathVariable("id") Long id)
    {
        return studentService.getStudentbyId(id);
    }

    @PutMapping("/updateStudent/{id}")
    public String updateStudent(@PathVariable("id") Long id, @RequestBody StudentRequestDto studentRequestDto) {
        return studentService.updateStudent(id, studentRequestDto);
    }

    @DeleteMapping("/deleteStudentById/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        return studentService.deleteStudent(id);
    }
}
